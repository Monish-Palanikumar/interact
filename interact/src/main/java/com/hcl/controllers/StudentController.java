package com.hcl.controllers;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.model.Booking;
import com.hcl.model.Instructor;
import com.hcl.model.Student;
import com.hcl.model.Timings;
import com.hcl.service.BookingService;
import com.hcl.service.InstructorService;
import com.hcl.service.StudentService;
import com.hcl.service.TimingsService;

@Controller
public class StudentController {
	@Autowired
	InstructorService instructorService;

	@Autowired
	StudentService studentService;

	@Autowired
	BookingService bookingService;

	@Autowired
	TimingsService timingsService;

	@RequestMapping("/student/getInstructorsBySubject")
	public String getAllInstructors(@RequestParam("subject") String subject, @RequestParam("board") String board,
			@RequestParam("grade") Integer grade, ModelMap m) {
		List<Instructor> list = instructorService.getInstructorsBySubject(subject, board, grade);
		m.addAttribute("instructors", list);
		return "subjectInstructors";
	}

	@RequestMapping("/student/getInstructorsByAvailability")
	public String getInstructorsByAvailability(@RequestParam("availability") String availability, ModelMap m) {
		List<Instructor> list = instructorService.getInstructorsByAvailability(availability);
//		list is ordered by ratings in descending order
		m.addAttribute("ins", list);
		return "availableInstructors";
	}

	@RequestMapping(value = "/student/book")
	public String bookInstructor(@RequestParam("id") Integer id, ModelMap m, HttpServletRequest request) {
		Instructor ins = instructorService.getInstructorById(id);
		HttpSession session = request.getSession();
		int sid = (Integer) session.getAttribute("student_id");
		Student stud = studentService.getStudentById(sid);
		List<Booking> instructorBookings = bookingService.findByInstructor(id);
		List<Timings> timings = timingsService.getAllTimings();

		for (Booking b : instructorBookings) {
			timings.remove(timingsService.getTimings(b.getStart()));
			timings.remove(timingsService.getTimings(b.getEnd()));
		}
		m.addAttribute("instructor", ins);
		m.addAttribute("student", stud);
		m.addAttribute("timings", timings);
		return "booking";
	}

	@RequestMapping(value = "/student/confirm")
	public String confirmBooking(@ModelAttribute("booking") Booking b, ModelMap m) {
//		public String confirmBooking(@RequestParam("iid") Integer iid, @RequestParam("sid") Integer sid, @RequestParam("start") Time start, @RequestParam("end") Time end, ModelMap m)

		LocalTime time1 = LocalTime.parse(String.valueOf(b.getStart()));
		LocalTime time2 = LocalTime.parse(String.valueOf(b.getEnd()));
		LocalTime lowerBound = LocalTime.parse("09:00");
		LocalTime upperBound = LocalTime.parse("21:00");
		int flag = time1.compareTo(time2);
		if (flag < 0) {
//			time1 < time2
			int flag1 = time1.compareTo(lowerBound);
			if (flag1 >= 0) {
//				startTime greater than lower time bound
				int flag2 = time2.compareTo(upperBound);
				if (flag2 <= 0) {
//					endTime lesser than upper time bound
					if (MINUTES.between(time1, time2) == 60) {
//						Exact 1hr time bound
						bookingService.saveBooking(b);
						m.addAttribute("booking", b);
						return "bookingConfirm";
					} else {
//						Time bound error
						return "error";
					}
				} else {
//					endTime greater than upper time bound
					return "error";
				}
			} else {
//				startTime lesser than lower time bound
				return "error";
			}

		} else {
//			time1 > time2
			return "error";
		}
	}

	@RequestMapping("/student/validateStudent")
	public String validateStudent(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap m, HttpSession session) {
		Student s = studentService.getStudentByUsernameAndPassword(username, password);
		if (s != null) {
//			valid user... add to session
			session.setAttribute("student_id", s.getId());
			session.setAttribute("student_name", s.getName());
			session.setAttribute("student_board", s.getBoard());
			session.setAttribute("student_grade", s.getGrade());
			return "studentDashboard";
		} else {
//			invalid user.... return error page
			m.addAttribute("message", "Invalid Credentials");
			return "error";
		}

	}

	@RequestMapping("/student/showDashboard")
	public String showStudentDashboard(HttpServletRequest request, ModelMap m) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("student_name");
		if (username != null) {
//			user logged in
			Integer id = (Integer) session.getAttribute("student_id");
			List<Booking> list = studentService.getSchedule(id);
			List<Instructor> insList = new ArrayList<Instructor>();
			for (Booking b : list) {
				insList.add(instructorService.getInstructorById(b.getIid()));
			}
			m.addAttribute("schedule", list);
			m.addAttribute("insList", insList);
			return "studentDashboard";
		} else {
			return "login";
		}
	}

	@RequestMapping("/student/getSubjects")
	public String getSubjects(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("student_name");
		if (username != null) {
//				user logged in
			return "student";
		} else {
			return "login";
		}

	}

	@RequestMapping("/student/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
			return "login";
		} else {
			return "error";
		}
	}
}

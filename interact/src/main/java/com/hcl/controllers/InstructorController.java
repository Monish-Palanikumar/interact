package com.hcl.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.model.Booking;
import com.hcl.model.Instructor;
import com.hcl.model.Student;
import com.hcl.service.BookingService;
import com.hcl.service.InstructorService;
import com.hcl.service.StudentService;

@Controller
public class InstructorController {
	@Autowired
	BookingService bookingService;

	@Autowired
	StudentService studentService;

	@Autowired
	InstructorService instructorService;

	@RequestMapping("/instructor")
	public String showRegisterForm(ModelMap m) {
		return "registerInstructor";
	}

	@RequestMapping("/instructor/getSchedule")
	public String getSchedule(ModelMap m, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("instructor_id");
		Instructor i = instructorService.getInstructorById(id);
		List<Booking> list = bookingService.findByInstructor(id);
		List<Student> stuList = new ArrayList<Student>();
		for (Booking b : list) {
			Student s = studentService.getStudentById(b.getSid());
			stuList.add(s);
		}
		m.addAttribute("stuList", stuList);
		m.addAttribute("bookings", list);
		return "instructor";
	}

	@RequestMapping(value = "/instructor/register", method = RequestMethod.GET)
	public String registerInstructor(@RequestParam("name") String name, @RequestParam("experience") Integer experience,
			@RequestParam("contactNumber") String contactNumber,
			@RequestParam("gradePreference") String gradePreference,
			@RequestParam("boardPreference") String boardPreference,
			@RequestParam("subjectPreference") String subjectPreference, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("availability") String availability, ModelMap m) {
		instructorService.saveInstructor(name, experience, contactNumber, gradePreference, boardPreference,
				subjectPreference, username, password, availability);
		return "instructorLogin";
	}

	@RequestMapping("/instructor/login")
	public String showLogin() {
		return "instructorLogin";
	}

	@RequestMapping("/instructor/validateInstructor")
	public String validateInstructor(@RequestParam("username") String username,
			@RequestParam("password") String password, ModelMap m, HttpSession session) {
		Instructor i = instructorService.getInstructorByUsernameAndPassword(username, password);
		if (i != null) {
//			valid user... add to session
			session.setAttribute("instructor_id", i.getId());
			session.setAttribute("instructor_name", i.getName());
			session.setAttribute("instructor_gradepreference", i.getGradePreference());
			session.setAttribute("instructor_subjectPreference", i.getSubjectPreference());
			session.setAttribute("instructor_boardPreference", i.getBoardPreference());
			return "instructorDashboard";
		} else {
//			invalid user.... return error page
			m.addAttribute("message", "Invalid Credentials");
			return "error";
		}
	}

	@RequestMapping("/instructor/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
			return "instructorLogin";
		} else {
			return "error";
		}
	}
}

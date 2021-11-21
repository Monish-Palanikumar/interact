package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Booking;
import com.hcl.model.Student;
import com.hcl.repos.BookingRepository;
import com.hcl.repos.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	BookingRepository bookingRepo;

	public Student getStudentById(Integer id) {
		return studentRepo.findById(id).get();
	}

	public void savestudent(String name, Integer grade, String board, String contactNumber, String username,
			String password) {
		studentRepo.saveStudent(name, grade, board, contactNumber, username, password);
	}

	public Student getStudentByUsernameAndPassword(String username, String password) {
		return studentRepo.getStudentByUsernameAndPassword(username, password);
	}

	public List<Booking> getSchedule(Integer id) {
		return bookingRepo.getSchedule(id);
	}
}

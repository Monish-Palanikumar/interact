package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Instructor;
import com.hcl.repos.InstructorRepository;

@Service
public class InstructorService {
	@Autowired
	InstructorRepository instructorRepo;

	public List<Instructor> getInstructorsByAvailability(String availability) {
		return instructorRepo.findByAvailability(availability);
	}

	public List<Instructor> getInstructorsBySubject(String subject, String board, Integer grade) {
		return instructorRepo.findBySubject(subject, board, grade);
	}

	public Instructor getInstructorById(Integer id) {
		return instructorRepo.findById(id).get();
	}

	public void saveInstructor(String name, Integer experience, String ContactNumber, String gradePreference,
			String boardPreference, String subjectPreference, String username, String password, String availability) {
		instructorRepo.saveInstructor(name, experience, ContactNumber, gradePreference, boardPreference,
				subjectPreference, username, password, availability);
	}

	public Instructor getInstructorByUsernameAndPassword(String username, String password) {
		return instructorRepo.getInstructorByUsernameAndPassword(username, password);
	}
}

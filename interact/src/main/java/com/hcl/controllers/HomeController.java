package com.hcl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/")
	public String index() {
		return "index"; // view name
	}

	@RequestMapping("/student")
	public String showRegisterForm(ModelMap m) {
		return "registerStudent";
	}

	@RequestMapping(value = "/student/register", method = RequestMethod.GET)
	public String registerStudent(@RequestParam("name") String name, @RequestParam("grade") Integer grade,
			@RequestParam("board") String board, @RequestParam("contactNumber") String contactNumber,
			@RequestParam("username") String username, @RequestParam("password") String password, ModelMap m) {
		studentService.savestudent(name, grade, board, contactNumber, username, password);
		return "login";
	}

	@RequestMapping("/student/login")
	public String loginStudent(ModelMap m) {
		return "login";
	}

//	@RequestMapping("/student")
//	public String student() {
//		return "student";
//	}

}

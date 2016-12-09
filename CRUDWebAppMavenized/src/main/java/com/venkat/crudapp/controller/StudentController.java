package com.venkat.crudapp.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.venkat.crudapp.entity.Student;
import com.venkat.crudapp.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/index")
	public String setupForm(Model map){
		Student student = new Student();
		map.addAttribute("student", student);
		map.addAttribute("studentList", studentService.getAllStudents());
		return "student";
	}
	
	@RequestMapping(value="/student.do",method=RequestMethod.POST )
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action,
			Model map){
		Student studentResult = new Student();
		switch(action.toLowerCase()){
		case "add":
			studentService.addStudent(student);
			studentResult = student;
			break;
		case "edit":
			studentService.updateStudent(student);
			studentResult = student;
			break;
		case "delete":
			studentService.deleteStudent(student.getStudentId());
			studentResult = new Student();
			break;
		case "search":
			Student searchedStudent = studentService.getStudentById(student.getStudentId());
			studentResult = searchedStudent != null ? searchedStudent : new Student();
			break;
			
		}
		map.addAttribute("student", studentResult);
		map.addAttribute("studentList", studentService.getAllStudents());
		return "student";
	}
}

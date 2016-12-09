package com.venkat.crudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.venkat.crudapp.dao.StudentDao;
import com.venkat.crudapp.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao dao;
	
	@Transactional
	public void addStudent(Student student) {
		dao.addStudent(student);
	}

	@Transactional
	public void updateStudent(Student student) {
		dao.updateStudent(student);
	}

	@Transactional
	public void deleteStudent(int studentId) {
		dao.deleteStudent(studentId);
	}

	@Transactional
	public Student getStudentById(int studentId) {
		return dao.getStudentById(studentId);
	}

	@Transactional
	public List getAllStudents() {
		return dao.getAllStudents();
	}

}

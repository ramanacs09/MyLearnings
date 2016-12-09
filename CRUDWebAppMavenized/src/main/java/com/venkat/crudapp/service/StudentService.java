package com.venkat.crudapp.service;

import java.util.List;

import com.venkat.crudapp.entity.Student;

public interface StudentService {

	public void addStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(int studentId);
	public Student getStudentById(int studentId);
	public List getAllStudents();
}

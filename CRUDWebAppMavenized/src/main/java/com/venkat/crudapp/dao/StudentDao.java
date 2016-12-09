package com.venkat.crudapp.dao;

import java.util.List;

import com.venkat.crudapp.entity.Student;
/*
 * 
 * @author user
 *  Interface for Student Dao
 */
public interface StudentDao {
	public void addStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(int studentId);
	public Student getStudentById(int studentId);
	public List getAllStudents();
	
}

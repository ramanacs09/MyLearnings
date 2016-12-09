package com.venkat.crudapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.venkat.crudapp.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void addStudent(Student student) {
		factory.openSession().save(student);
	}

	@Override
	public void updateStudent(Student student) {
		factory.openSession().update(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		factory.openSession().delete(getStudentById(studentId));
	}

	@Override
	public Student getStudentById(int studentId) {
		return (Student) factory.openSession().get(Student.class, studentId);
	}

	@Override
	public List getAllStudents() {
		return factory.openSession().createQuery("from Student").list();
	}

}

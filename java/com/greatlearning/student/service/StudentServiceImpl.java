package com.greatlearning.student.service;

import org.springframework.stereotype.Repository;

import com.greatlearning.student.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	
	//create session
	private  Session session;
	
	@Autowired
	StudentServiceImpl (SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
		try {
			session=sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session=sessionFactory.openSession();
		}
	}
	
	@Transactional
	public List<Student> findAll(){
		
		Transaction tx = session.beginTransaction();
		
		List<Student> students = session.createQuery("from student").list();
		
		tx.commit();
		
		return students;
		
	}
	
	@Transactional 
	public Student findById(int id) {
		
		Student student = new Student();
		
		Transaction tx = session.beginTransaction();
		
		student = session.get(Student.class, id);
		 tx.commit();
		 
		 return student;
	}
	
	@Transactional
	public void save(Student theStudent) {

		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(theStudent);
		
		tx.commit();
	}
	
	@Transactional
	public void deleteById(int theId) {
		
		Transaction tx = session.beginTransaction();
		
		Student student = session.get(Student.class, theId);
		
		session.delete(student);
		tx.commit();
	}
}

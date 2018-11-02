package com.caps.dev.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.model.JPAUtils;

import associations.many_to_many.Students_Unidirectional;
import associations.many_to_many.Teacher;
import associations.one_to_many.Pencil;

public class HibernateJPAAppManyToMany {
	public static void main(String[] args) {

		Teacher t1=new Teacher();
		Set<Teacher> list=new HashSet<Teacher>();
		t1.setId(1);
		t1.setName("ABC");
		t1.setSubject("XYZ");
		list.add(t1);
		
		
		Teacher t2=new Teacher();
		t2.setId(2);
		t2.setName("DEF");
		t2.setSubject("WXY");
		list.add(t2);
		
		
		List<Students_Unidirectional> students = new ArrayList<Students_Unidirectional>();
		
		Students_Unidirectional s1 = new Students_Unidirectional();
		s1.setAge(100);
		s1.setId(1);
		s1.setList(list);
		s1.setName("Mustaq");
		s1.setAge(101);
		students.add(s1);
		
		
		Students_Unidirectional s2 = new Students_Unidirectional();
		s2.setAge(10);
		s2.setId(2);
		s2.setList(list);
		s2.setName("Md");
		s2.setAge(102);
		students.add(s2);
		
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t1);
		em.getTransaction().commit();
		em.close();
	}
}

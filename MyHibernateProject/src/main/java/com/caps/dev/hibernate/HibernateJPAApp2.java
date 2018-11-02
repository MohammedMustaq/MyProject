package com.caps.dev.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.model.JPAUtils;
import com.test.entities.associations.one_to_one.Address;
import com.test.entities.associations.one_to_one2.College_OneToOneUnidirectional;
import com.test.entities.associations.one_to_one2.Faculty;

public class HibernateJPAApp2 {
	public static void main(String[] args) {
		College_OneToOneUnidirectional p =
				new College_OneToOneUnidirectional();
	p.setId(2);
	p.setName("vhvh");
	p.setType("bhb");
	
	Faculty fac=new Faculty();
	fac.setFaculty_id(102);
	fac.setFaculty_name("jbjs");
	fac.setFaculty_subject("hbvh");
	
	p.setFaculty(fac);
	
	EntityManagerFactory emf = JPAUtils.getEMF();
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	
	em.persist(p);
	
	em.getTransaction().commit();
	em.close();
	}
}
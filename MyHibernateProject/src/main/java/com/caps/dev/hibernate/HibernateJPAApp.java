package com.caps.dev.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.model.JPAUtils;
import com.test.entities.associations.one_to_one.Address;
import com.test.entities.associations.one_to_one.Person_OneToOneUnidirectional;

public class HibernateJPAApp {
	public static void main(String[] args) {
		Person_OneToOneUnidirectional p =
					new Person_OneToOneUnidirectional();
		p.setName("Blake");
		p.setAge(56);
		p.setId(101);
		
		Address addr = new Address();
		addr.setAddress_id(1);
		addr.setCity("Bangalore");
		addr.setPin(624001);
		addr.setState("Karnataka");
		
		p.setAddress(addr);
		
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(p);
		
		em.getTransaction().commit();
		em.close();
	}
}
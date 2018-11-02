package com.caps.dev.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.model.JPAUtils;

import associations.one_to_many.Pencil;
import associations.one_to_many.PencilBox_UniDirectional;

public class HibernateJPAAppOneToMany {
	public static void main(String[] args) {

		PencilBox_UniDirectional pbox = new PencilBox_UniDirectional();
		pbox.setId(101);
		pbox.setSize("10");
		
		List<Pencil> pencils = new ArrayList<Pencil>();
		
		Pencil p1 = new Pencil();
		p1.setName("Natraj");
		p1.setPencilId(1);
		pencils.add(p1);
		
		
		Pencil p2 = new Pencil();
		p2.setName("Apsara");
		p2.setPencilId(2);
		pencils.add(p2);
		
		Pencil p3 = new Pencil();
		p3.setName("Camlin");
		p3.setPencilId(3);
		pencils.add(p3);
		
		pbox.setPencils(pencils);
		
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pbox);
		em.getTransaction().commit();
		em.close();
	}
}

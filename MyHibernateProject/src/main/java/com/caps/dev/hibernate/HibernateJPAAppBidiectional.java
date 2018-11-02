package com.caps.dev.hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.caps.model.JPAUtils;
import com.test.entities.associations.one_to_one.User_OneToOneBidirectional;
import com.test.entities.associations.one_to_one.VoterCard;

public class HibernateJPAAppBidiectional {
	public static void main(String[] args) {
		User_OneToOneBidirectional u=new User_OneToOneBidirectional();
		u.setUser_id(1);
		u.setName("dkncj");
		VoterCard v=new VoterCard();
		v.setVoter_id(102);
		u.setVoterCard(v);
		
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		int id=Integer.parseInt(sc.nextLine());
		User_OneToOneBidirectional user=em.find(User_OneToOneBidirectional.class, id);
		
		em.getTransaction().commit();
		em.close();
		System.out.println(user);
	}
}
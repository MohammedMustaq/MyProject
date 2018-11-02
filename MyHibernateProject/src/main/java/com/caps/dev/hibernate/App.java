package com.caps.dev.hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.caps.dev.beans.Movie;
import com.caps.model.JPAUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		save();
		}
	
	public static void save() {
		System.out.println("Enter Movie Details");
		System.out.println("-------------------");
		 Movie movie = new Movie();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter movie id: ");
		movie.setMovieId(Integer.parseInt(in.nextLine()));

		System.out.println("Enter movie name: ");
		movie.setMovieName(in.nextLine());

		System.out.println("Enter movie ratings: ");
		movie.setRatings(Double.parseDouble(in.nextLine()));

		System.out.println("Enter movie summary: ");
		movie.setSummmary(in.nextLine());
		System.out.println("Movie Saved");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistanceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(movie);
		tx.commit();
	}
	public static void getMovieById() {
		System.out.println("Enter a movie id: ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Movie m = em.find(Movie.class, id);
		//Movie m=em.getReference(Movie.class, id);
		tx.commit();
		em.close();
		emf.close();
		sc.close();
		System.out.println(m);
	}
	public static void remove()
	{
		System.out.println("Enter a movie id to del : ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		EntityManagerFactory emf = JPAUtils.getEMF();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Movie m = em.find(Movie.class,id);
		em.remove(m);
		tx.commit();
		sc.close();
		
	}
	public static void updateRatings()
	{
		System.out.println("Enter a movie id to del : ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("enter the ratings");
		Double ratings=Double.parseDouble(sc.nextLine());
		EntityManager em=JPAUtils.getEMF().createEntityManager();
		em.getTransaction().begin();
		Movie m=em.find(Movie.class, id);
		m.setRatings(ratings);
		em.getTransaction().commit();
		em.close();
		sc.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
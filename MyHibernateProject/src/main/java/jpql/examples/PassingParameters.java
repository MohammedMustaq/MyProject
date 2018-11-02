package jpql.examples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.caps.dev.beans.Movie;
import com.caps.model.JPAUtils;


public class PassingParameters {
	public static void main(String[] args) {
		EntityManagerFactory factory = JPAUtils.getEMF();
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		//In JPQL the positional parameters starts with 1 and it is appended
		//by the positional number
		TypedQuery<Movie> query = em
				.createQuery("FROM Movie m where m.movieId= ?1 ",Movie.class);
		query.setParameter(1, 1);
		
		List<Movie> list = query.getResultList();
		
		for(Movie s:list){
			System.out.println(s.getMovieName());
		}
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
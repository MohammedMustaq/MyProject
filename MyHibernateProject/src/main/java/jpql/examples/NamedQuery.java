package jpql.examples;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.caps.dev.beans.Movie;
import com.caps.model.JPAUtils;

public class NamedQuery {
	public static void main(String[] args) {
		EntityManagerFactory factoryManager = JPAUtils.getEMF();
		EntityManager em = factoryManager.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
//		Query query = em.createQuery("from Movie s order by s.movieId");
		TypedQuery<Movie> query = em
				.createNamedQuery("getAllMovies", Movie.class);
		
		
		
		List<Movie> movie = query.getResultList();
		for(Movie s:movie){
			System.out.println(s.getMovieName());
		}
		
		tx.commit();
		em.close();
		factoryManager.close();
	}

}

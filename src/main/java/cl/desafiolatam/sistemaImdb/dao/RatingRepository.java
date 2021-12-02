package cl.desafiolatam.sistemaImdb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.sistemaImdb.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{
	
	List<Rating> findAll();

}

package cl.desafiolatam.sistemaImdb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.sistemaImdb.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
	
	List<Show> findAll();

}

package cl.desafiolatam.sistemaImdb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.sistemaImdb.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	User findByUsername(String username);
	User findByEmail(String email);
	

}

package cl.desafiolatam.sistemaImdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.sistemaImdb.dao.RoleRepository;
import cl.desafiolatam.sistemaImdb.dao.UserRepository;
import cl.desafiolatam.sistemaImdb.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void saveWithUserRole(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		
	}

	public void saveWithAdminRole(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		
	}
}

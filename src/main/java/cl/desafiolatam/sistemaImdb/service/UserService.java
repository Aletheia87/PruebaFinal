package cl.desafiolatam.sistemaImdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.sistemaImdb.dao.RoleRepository;
import cl.desafiolatam.sistemaImdb.dao.UserRepository;
import cl.desafiolatam.sistemaImdb.model.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void saveWithUserRole(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		
	}

	@Override
	public void saveWithAdminRole(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
		
	}
	
	@Override
	public User findUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
		
	}
	
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
		
	}
	
	@Override
	public void createUser(User user) {
		userRepository.save(user);
		
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}
	
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

}
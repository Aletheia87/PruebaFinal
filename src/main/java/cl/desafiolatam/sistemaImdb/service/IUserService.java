package cl.desafiolatam.sistemaImdb.service;

import java.util.List;

import cl.desafiolatam.sistemaImdb.model.User;

public interface IUserService {

	public void saveWithUserRole(User user);
	public void saveWithAdminRole(User user);
	public User findByUsername(String username);
	public User findUserById(Long id);
	public User findUserByEmail(String email);
	public List<User> findAllUsers();
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(Long id);
	
}

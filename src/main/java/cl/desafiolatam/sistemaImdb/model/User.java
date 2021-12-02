package cl.desafiolatam.sistemaImdb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, unique = true)
	private Long id;
	
	@Size(min = 3, message = "Username must be present")
	private String username;
	
	@Size(min = 5, message = "Email must be greater than 5 characters")
	private String email;
	
	@Size(min = 8, message = "Password must be greater than 8 characters")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	//1:N Show
	@OneToMany(mappedBy = "creatorShow", fetch = FetchType.LAZY)
	private List<Show> userShows;

	//1:N Rating
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Rating> ratings;
	
	//N:N Roles
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
}

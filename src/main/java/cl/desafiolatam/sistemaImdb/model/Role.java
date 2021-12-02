package cl.desafiolatam.sistemaImdb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "role_id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "role_name")
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
}

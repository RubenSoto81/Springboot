package Ejercicio.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;


@Entity
public @Data class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String username;
	private String email;
	private String password;
	private Boolean enabled;
	
	// Mediante la anotación @JoinColumn es posible personalizar las columnas que será utilizadas como uniones con otras tablas. 
	 // Cuando trabajamos con relaciones como @ManyToOne o @OneToOne, es necesario indicarle a JPA como es que tendrá que realizar
	  // la unión (JOIN) con la otra Entidad.
	@ManyToMany(cascade = CascadeType.ALL)  // Un usuario puede tener mas de un rol y un rol puede ser de varios usuarios
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles;  // Lista de roles
}

package com.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Data
@Table(name="users")
public class User 
{
	

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer uid;
	
	@NotEmpty
	@Column(nullable = false)
	private String firstName;
	
	private String lastName;
	
	@Column(nullable = false,unique = true)
	@NotEmpty
	@Email(message = "{errors.invalid.email}")
	private String email;
	
	
	private String password;
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(
			name="user_role",
			joinColumns = {@JoinColumn(name="USER_ID",referencedColumnName = "uid")},
			inverseJoinColumns = {@JoinColumn(name="ROLE_ID",referencedColumnName = "rid")})
	private List<Role> roles;
	
	public User(User user)
	{
		
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}
	
	public User() {}
}

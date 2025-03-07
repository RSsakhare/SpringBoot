package com.model;

import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class Role 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rid;
	
	@Column(nullable = false,unique = true)
	@NotEmpty
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
}

package com.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.*;

public interface UserRepository extends JpaRepository<User, Integer> 
{
	Optional<User> findUserByEmail(String email);
}

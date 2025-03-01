package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.*;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>
{
	
	    List<Player> findByCountry(String country);
	    List<Player> findByAverageScoreGreaterThan(double score);
		List<Player> findByAverageScoreGreaterThanOrderByAverageScoreDescDateOfBirthAsc(double score);
}

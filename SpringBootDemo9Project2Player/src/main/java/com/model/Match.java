package com.model;



import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Component
@Entity
public class Match 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int matchId;
	    private int score;
	    private String stadium;
	
}

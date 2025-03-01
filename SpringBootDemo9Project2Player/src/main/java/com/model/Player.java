package com.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Component
@Entity
public class Player 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private String playerName;
	private String dateOfBirth;
	private String country;
	private double averageScore;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "match_id")
	private Match match;
}

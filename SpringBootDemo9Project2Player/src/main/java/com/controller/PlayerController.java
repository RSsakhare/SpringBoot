package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dao.*;
import com.model.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController 
{
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getAllPlayers() 
    {
        return playerRepository.findAll();
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) 
    {
        return playerRepository.save(player);
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable int playerId) 
    {
        return playerRepository.findById(playerId).orElse(null);
    }

    @PutMapping("/{playerId}")
    public Player updatePlayer(@PathVariable int playerId, @RequestBody Player playerDetails) 
    {
        Player player = playerRepository.findById(playerId).orElse(null);
        player.setPlayerName(playerDetails.getPlayerName());
        player.setDateOfBirth(playerDetails.getDateOfBirth());
        player.setCountry(playerDetails.getCountry());
        return playerRepository.save(player);            
    }

    @DeleteMapping("/{playerId}")
    public Player deletePlayer(@PathVariable int playerId)
    {
    	 Player player = playerRepository.findById(playerId).orElse(null);
    	 playerRepository.delete(player);
    	 return player;
    }

    @GetMapping("/country/{country}")
    public List<Player> getPlayersByCountry(@PathVariable String country) {
        return playerRepository.findByCountry(country);
    }
    
    @GetMapping("/averageScore/{score}")
    public List<Player> getPlayersByAverageScore(@PathVariable double score)
    {
        return playerRepository.findByAverageScoreGreaterThan(score);
    }
    
    @GetMapping("/sortedAverageScore/{score}")
    public List<Player> getPlayersBySortedAverageScore(@PathVariable double score) {
        return playerRepository.findByAverageScoreGreaterThanOrderByAverageScoreDescDateOfBirthAsc(score);
    }
}

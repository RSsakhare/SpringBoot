package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dao.*;
import com.model.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController 
{
    @Autowired
    private MatchRepository matchRepository;

    @GetMapping
    public List<Match> getAllMatches() 
    {
        return matchRepository.findAll();
    }

    @PostMapping
    public Match createMatch(@RequestBody Match match)
    {
        return matchRepository.save(match);
    }

    @GetMapping("/{matchId}")
    public Match getMatchById(@PathVariable int matchId) 
    {
        return matchRepository.findById(matchId).orElse(null);
    }

    @PutMapping("/{matchId}")
    public Match updateMatch(@PathVariable int matchId, @RequestBody Match matchDetails) 
    {
        Match match = matchRepository.findById(matchId).orElse(null);
        match.setScore(matchDetails.getScore());
        match.setStadium(matchDetails.getStadium());
        return matchRepository.save(match);
    }

    @DeleteMapping("/{matchId}")
    public Match deleteMatch(@PathVariable int matchId) 
    {
    	 Match match = matchRepository.findById(matchId).orElse(null);
         matchRepository.delete(match);
         return match;
    }

}

package com.student.ibmproject.controllers;
import com.student.ibmproject.entities.Team;
import com.student.ibmproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        Team addedTeam = teamService.addTeam(team);
        return new ResponseEntity<>(addedTeam, HttpStatus.CREATED);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<Team> getTeamById(@PathVariable int teamId) {
        Team team = teamService.getTeamById(teamId);
        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{teamId}")
    public ResponseEntity<String> deleteTeam(@PathVariable int teamId) {
        Team team = teamService.getTeamById(teamId);
        if (team != null) {
            teamService.deleteTeam(teamId);
            return new ResponseEntity<>("Team with ID " + teamId + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Team with ID " + teamId + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{teamId}")
    public ResponseEntity<Team> updateTeam(@PathVariable int teamId, @RequestBody Team updatedTeam) {
        Team team = teamService.getTeamById(teamId);
        if (team != null) {
            team.setTeamName(updatedTeam.getTeamName());
            team.setActivity(updatedTeam.getActivity());
            Team updated = teamService.updateTeam(teamId,team);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/enroll/{teamId}")
    public ResponseEntity<Team> enrollActivity(@PathVariable int teamId, @RequestBody Team updatedTeam) {
        Team team = teamService.getTeamById(teamId);
        if (team != null) {
            team.setActivity(updatedTeam.getActivity());
            Team updated = teamService.enrollActivity(teamId,team);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


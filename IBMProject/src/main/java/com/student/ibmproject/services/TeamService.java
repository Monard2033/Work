package com.student.ibmproject.services;
import com.student.ibmproject.exceptions.CustomException;
import com.student.ibmproject.repositories.ActivityRepository;
import com.student.ibmproject.entities.Team;
import com.student.ibmproject.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, ActivityRepository activityRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team getTeamById(Integer id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        return teamOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "There is no team with id : " + id));
    }

    public void deleteTeam(int teamId) {
        teamRepository.deleteById(teamId);
    }

    public Team updateTeam(int teamId, Team updatedTeam) {
        Team existingTeam = teamRepository.findById(teamId).orElseThrow((() -> new RuntimeException("Team with id: "+ teamId + " not found")));
        if (existingTeam != null) {
            existingTeam.setTeamName(updatedTeam.getTeamName());
            existingTeam.setActivity(updatedTeam.getActivity());
            return teamRepository.save(existingTeam);
        }
        return null;
    }

    public Team enrollActivity(int teamId, Team updatedTeam) {
        Team existingTeam = teamRepository.findById(teamId).orElseThrow((() -> new RuntimeException("Team with id: "+ teamId + " not found")));
        if (existingTeam != null) {
            existingTeam.setActivity(updatedTeam.getActivity());
            return teamRepository.save(existingTeam);
        }
        return null;
    }
}

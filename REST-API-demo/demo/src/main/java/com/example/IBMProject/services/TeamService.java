package com.example.IBMProject.services;
import com.example.IBMProject.entities.Activity;
import com.example.IBMProject.entities.Team;
import com.example.IBMProject.repository.ActivityRepository;
import com.example.IBMProject.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final ActivityRepository activitiesRepository;
    @Autowired
    public TeamService(TeamRepository teamRepository, ActivityRepository activityRepository) {
        this.teamRepository = teamRepository;
        this.activitiesRepository = activityRepository;
    }

    @Transactional(readOnly = true)
    public Team getTeamById(int teamId) {
        return teamRepository.findById(teamId).orElse(null);
    }

//    @Transactional(readOnly = true)
//    public List<Team> getAllStudentsFromTeam(int teamId) {
//        Team team = teamRepository.findById(teamId).orElse(null);
//        if (team != null) {
//            return team.getStudents();
//        }
//        return null;
//    }

    @Transactional
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Transactional
    public void deleteTeam(int teamId) {
        teamRepository.deleteById(teamId);
    }
    public Team enrollTeamInActivity(int teamId, int activityId) {
        Team team = teamRepository.findById(teamId).orElse(null);
        Activity activity = activitiesRepository.findById(activityId).orElse(null);

        if (team != null && activity != null) {
           // team.getActivities().add(activity);
            return teamRepository.save(team);
        }

        return null;
    }
}

package com.example.IBMProject.Controller;
import com.example.IBMProject.entities.Team;
import com.example.IBMProject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @DeleteMapping("/delete")
    public void deleteTeam(@PathVariable int teamId) {
        teamService.deleteTeam(teamId);
    }

    @PostMapping("/{teamId}/enroll/{activityId}")
    public Team enrollTeamInActivity(@PathVariable int teamId, @PathVariable int activityId) {
        return teamService.enrollTeamInActivity(teamId, activityId);
    }
}

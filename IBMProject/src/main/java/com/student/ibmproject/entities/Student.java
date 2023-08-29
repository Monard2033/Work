package com.student.ibmproject.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

@Table(name="students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "team_lead")
    private Boolean teamLead;

    @Column(name = "team_id")
    private int TeamID;

    @Column(name = "part_of_team")
    private Boolean part_of_team;

    @ManyToOne
    @MapsId(value = "team_id")
    @JoinColumn(name = "team_id")
    private Team TeamName;

//    @OneToMany(mappedBy = "StudentName")
//    private List<Session> sessions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(Boolean teamLead) {
        this.teamLead = teamLead;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    @JsonBackReference
    public Team getTeamName() {
        return TeamName;
    }

    public void setTeamName(Team teamName) {
        TeamName = teamName;
    }

    public Boolean getPart_of_team() {
        return part_of_team !=null;
    }

    public void setPart_of_team(Boolean part_of_team) {
        this.part_of_team = part_of_team;
    }

//    @JsonManagedReference
//    public List<Session> getSessions() {
//        return sessions;
//    }
//
//    public void setSessions(List<Session> sessions) {
//        this.sessions = sessions;
//    }
}
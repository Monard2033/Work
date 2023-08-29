package com.student.ibmproject.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int teamId;

    @Column(name="name")
    private String teamName;

    @Column(name="activity_id")
    private int activity;

    @OneToMany(mappedBy = "TeamName", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    @ManyToOne
    @MapsId(value = "activity_id")
    @JoinColumn(name = "activity_id")
    private Activity ActivityName;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    @JsonManagedReference
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @JsonBackReference
    public Activity getActivityName() {
        return ActivityName;
    }

    public void setActivityName(Activity activityName) {
        ActivityName = activityName;
    }

}

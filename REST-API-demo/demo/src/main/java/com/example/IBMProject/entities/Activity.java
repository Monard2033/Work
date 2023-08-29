package com.example.IBMProject.entities;

import javax.persistence.*;
@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ActivityID")
    private int activityId;

    @Column(name="ActivityName")
    private String activityName;

    public Activity() {
    }

    public int getActivityId() {
        return activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public Activity(int activityId, String activityName) {
        this.activityId = activityId;
        this.activityName = activityName;
    }
}
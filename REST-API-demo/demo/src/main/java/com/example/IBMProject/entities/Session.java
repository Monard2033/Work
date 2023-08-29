package com.example.IBMProject.entities;
import javax.persistence.*;
@Entity
@Table(name="session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SessionID")
    private int sessionId;

    @Column(name="Date")
    private String date;

    @Column(name="Grade")
    private double grade;

    @Column(name="Attendance")
    private boolean attendance;

    public Session() {
    }

    public Session(int sessionId, String date, double grade, boolean attendance) {
        this.sessionId = sessionId;
        this.date = date;
        this.grade = grade;
        this.attendance = attendance;
    }
}

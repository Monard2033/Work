package com.example.IBMProject.entities;
import javax.persistence.*;
@Entity
@Table(name="mentor")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mentorId;

    @Column(name="MentorName")
    private String nameMentor;

    @Column(name="Email")
    private String email;

    public Mentor() {
    }

    public Mentor(int mentorId, String nameMentor, String email) {
        this.mentorId = mentorId;
        this.nameMentor = nameMentor;
        this.email = email;
    }
}

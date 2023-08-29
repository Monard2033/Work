package com.student.ibmproject.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="mentors")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_Id")
    private int mentorId;

    @Column(name="name")
    private String nameMentor;

    @Column(name="email")
    private String email;

    @Column(name = "session_Id")
    private int sessionId;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "mentor_sessions",
//            joinColumns = @JoinColumn(name = "mentor_Id"),
//            inverseJoinColumns = @JoinColumn(name = "session_Id")
//    )
//    private List<Session> sessions = new ArrayList<>();

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getNameMentor() {
        return nameMentor;
    }

    public void setNameMentor(String nameMentor) {
        this.nameMentor = nameMentor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

//    public List<Session> getSessions() {
//        return sessions;
//    }
//
//    public void setSessions(List<Session> sessions) {
//        this.sessions = sessions;
//    }

//    @PostPersist
//    private void updateMentorSessions() {
//        if (sessions != null) {
//            for (Session session : sessions) {
//                session.getMentors().add(this);
//            }
//        }
//    }
}

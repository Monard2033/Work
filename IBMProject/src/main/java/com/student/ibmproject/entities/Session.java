package com.student.ibmproject.entities;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sessions")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "sessionId")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int sessionId;

    @Column(name="date")
    private String date;

    @Column(name="grade")
    private double grade;

    @Column(name = "student_id")
    private int studentId;
    @Column(name="attendance")
    private boolean attendance;

    @Column(name = "activity_id")
    private int activity_id;

//    @ManyToOne
//    @MapsId(value = "student_id")
//    @JoinColumn(name = "student_id")
//    private Student StudentName;
//
//    @ManyToMany(mappedBy = "sessions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("sessions")
//    private List<Mentor> mentors = new ArrayList<>();
    
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

//    //@JsonBackReference
//    public Student getStudentName() {
//        return StudentName;
//    }
//
//    public void setStudentName(Student studentName) {
//        StudentName = studentName;
//    }
//
//    public List<Mentor> getMentors() {
//        return mentors;
//    }
//
//    public void setMentors(List<Mentor> mentors) {
//        this.mentors = mentors;
//    }
//
//    private void updateMentorSessions() {
//        for (Mentor mentor : mentors) {
//            mentor.getSessions().add(this);
//        }
//    }

}

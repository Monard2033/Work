package com.example.IBMProject.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TeamID")
    private int teamId;

    @Column(name="TeamName")
    private String teamName;

    @Column(name="Activities")
    private int activities;

    //@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   // @JoinTable(name="student",joinColumns = @JoinColumn(name="ID"))
   // private List<Team> students;

    //public List<Team> getStudents() {
    //    return students;
   // }


}

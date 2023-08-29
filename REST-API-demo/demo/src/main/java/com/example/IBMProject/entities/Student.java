package com.example.IBMProject.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "TeamLead")
    private Boolean teamLead;

    //@ManyToOne(fetch = FetchType.LAZY)
   // @JoinTable(name="team",joinColumns = @JoinColumn(name="teamID"))
    //private Team team;

    public Student() {}


    public Student(int id, String name, String email, String phone, boolean teamLead) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.teamLead = teamLead;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=' " + id +
                ",Name=' " + name + '\'' +
                ",Email=' " + email + '\'' +
                ",Phone=' " + phone + '\'' +
                ",TeamLead=' " + teamLead + '\'' +
                '}';
    }
}


package com.student.ibmproject.controllers;

import com.student.ibmproject.entities.Student;
import com.student.ibmproject.entities.Team;
import com.student.ibmproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student, Team team)
    {
        Student result = studentService.addStudent(student,team);
        if (student == null || team == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            studentService.addStudent(student, team);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "{Id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("Id") Integer id) {
       Student student = studentService.getStudentById(id);
       return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable int studentId, @RequestBody Student updatedStudent) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setPhone(updatedStudent.getPhone());
            student.setTeamLead(updatedStudent.getTeamLead());
            student.setTeamID(updatedStudent.getTeamID());
            Student updated = studentService.updateStudent(studentId,student);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            studentService.deleteStudent(studentId);
            return new ResponseEntity<>("Student with ID " + studentId + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with ID " + studentId + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}

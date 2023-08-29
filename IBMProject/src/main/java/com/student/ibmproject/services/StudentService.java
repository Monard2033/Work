package com.student.ibmproject.services;

import com.student.ibmproject.entities.Student;
import com.student.ibmproject.entities.Team;
import com.student.ibmproject.exceptions.CustomException;
import com.student.ibmproject.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student, Team team) {
        if (student.getPart_of_team()) {
            throw new IllegalStateException("Student is already in a team. Cannot add to another team.");
        }

        student.setTeamID(team.getTeamId());
        return studentRepository.save(student);
    }

    public Student getStudentById(Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "There is no student with id : " + id));
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student updateStudent(int studentId, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(studentId).orElseThrow((() -> new RuntimeException("Student with id: "+ studentId + " not found")));
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setPhone(updatedStudent.getPhone());
            existingStudent.setTeamLead(updatedStudent.getTeamLead());
            existingStudent.setTeamID(updatedStudent.getTeamID());
            return studentRepository.save(existingStudent);
        }
        return null;
    }
}

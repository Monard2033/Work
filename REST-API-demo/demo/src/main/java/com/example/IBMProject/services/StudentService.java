package com.example.IBMProject.services;

import com.example.IBMProject.entities.Student;
import com.example.IBMProject.exceptions.CustomException;
import com.example.IBMProject.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.*;

@Service //marcheaza layer-ul de Service,
//aici apeleam repository-ul care e primul layer "peste" baza de date
//si putem face diverse operatii peste obiectele aduse de repository
public class StudentService {

    private final StudentRepository studentRepository;

    //putem injecta dependintele si in mod clasic, folosind un contructor in loc de @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        List<Student> students;
        students = studentRepository.findAll();
        return students;
    }

    //daca incercam sa cautam un student dupa un id care nu exista in baza de date
    //vom primi 500 Interval Server Error, daca acest mesaj ajunge in frontend
    //user-ul nu va stii ce s-a intamplat, de aceea vom folosi Custom Exceptions si exception handler
    //astfel ca pentru un id care nu exista vom avea status 404 Not Found si un mesaj mai clar decat Internal Server Error
    //VEZI exceptions package
    public Student geStudentById(Integer id){
        Optional<Student> studentOptional =  studentRepository.findById(id);
        return studentOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"There is no student with id : " + id));
    }

    public Student addStudent(Student student){
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    public Student update(Student student){
        Optional<Student> entity = studentRepository.findById(student.getId());
        entity.orElseThrow((() -> new RuntimeException("Student with id: "+ student.getId() + " not found")));
        Student existingStudent = entity.get();
        Student savedStudent = studentRepository.save(existingStudent);
        return savedStudent;
    }

}
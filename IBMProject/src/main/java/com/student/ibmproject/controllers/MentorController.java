package com.student.ibmproject.controllers;
import com.student.ibmproject.entities.Mentor;
import com.student.ibmproject.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/mentors")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<Mentor> addMentor(@RequestBody Mentor mentor) {
        Mentor addedMentor = mentorService.addMentor(mentor);
        return new ResponseEntity<>(addedMentor, HttpStatus.CREATED);
    }
    @GetMapping("/by_id/{mentorId}")
    public ResponseEntity<Mentor> getMentorById(@PathVariable int mentorId) {
        Mentor mentor = mentorService.getMentorById(mentorId);
        if (mentor != null) {
            return new ResponseEntity<>(mentor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/by_name/{mentorName}")
    public ResponseEntity<Mentor> getMentorByName(@PathVariable String mentorName) {
        Mentor mentor = mentorService.getMentorByName(mentorName);
        if (mentor != null) {
            return new ResponseEntity<>(mentor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{mentorId}")
    public ResponseEntity<String> deleteMentor(@PathVariable int mentorId) {
        Mentor mentor = mentorService.getMentorById(mentorId);
        if (mentor != null) {
            mentorService.deleteMentor(mentorId);
            return new ResponseEntity<>("Mentor with ID " + mentorId + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Mentor with ID " + mentorId + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{mentorId}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable int mentorId, @RequestBody Mentor updatedMentor) {
        Mentor mentor = mentorService.getMentorById(mentorId);
        if (mentor != null) {
            mentor.setNameMentor(updatedMentor.getNameMentor());
            mentor.setEmail(updatedMentor.getEmail());
            Mentor updated = mentorService.updateMentor(mentorId,mentor);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


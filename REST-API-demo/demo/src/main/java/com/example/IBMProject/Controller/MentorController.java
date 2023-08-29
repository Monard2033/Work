package com.example.IBMProject.Controller;
import com.example.IBMProject.entities.Mentor;
import com.example.IBMProject.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/mentor")
public class MentorController {

    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public Mentor addMentor(@RequestBody Mentor mentor) {
        return mentorService.addMentor(mentor);
    }

    @GetMapping("/get")
    public Mentor getMentorById(@PathVariable int mentorId) {
        return mentorService.getMentorById(mentorId);
    }

    @DeleteMapping("/delete")
    public void deleteMentor(@PathVariable int mentorId) {
        mentorService.deleteMentor(mentorId);
    }
}

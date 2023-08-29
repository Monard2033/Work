package com.example.IBMProject.services;
import com.example.IBMProject.entities.Mentor;
import com.example.IBMProject.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Mentor addMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public Mentor getMentorById(int mentorId) {
        return mentorRepository.findById(mentorId).orElse(null);
    }

    public void deleteMentor(int mentorId) {
        mentorRepository.deleteById(mentorId);
    }
}

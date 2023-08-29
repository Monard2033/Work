package com.student.ibmproject.services;
import com.student.ibmproject.entities.Mentor;
import com.student.ibmproject.entities.Student;
import com.student.ibmproject.exceptions.CustomException;
import com.student.ibmproject.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public Mentor addMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public Mentor getMentorByName(String name) {
        List<Mentor> mentors = mentorRepository.findAll();
        for(Mentor mentor : mentors)
        {
            if(mentor.getNameMentor().equals(name))
            {
                return mentor;
            }
        }
        return null;
    }

    public Mentor getMentorById(Integer id) {
        Optional<Mentor> mentorOptional = mentorRepository.findById(id);
        return mentorOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "There is no mentor with id : " + id));
    }

    public void deleteMentor(int mentorId) {
        mentorRepository.deleteById(mentorId);
    }

    public Mentor updateMentor(int mentorId, Mentor updatedMentor) {
        Mentor existingMentor = mentorRepository.findById(mentorId).orElseThrow((() -> new RuntimeException("Mentor with id: "+ mentorId + "is not found")));
        if (existingMentor != null) {
            existingMentor.setMentorId(updatedMentor.getMentorId());
            existingMentor.setNameMentor(updatedMentor.getNameMentor());
            existingMentor.setEmail(updatedMentor.getEmail());
            return mentorRepository.save(existingMentor);
        }
        return null;
    }

}

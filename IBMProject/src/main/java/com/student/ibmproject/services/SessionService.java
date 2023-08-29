package com.student.ibmproject.services;
import com.student.ibmproject.entities.Session;
import com.student.ibmproject.exceptions.CustomException;
import com.student.ibmproject.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session getSessionById(Integer id) {
        Optional<Session> sessionOptional = sessionRepository.findById(id);
        return sessionOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "There is no Session with id : " + id));
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public void deleteSession(int sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    public Session updateSession(int sessionId, Session updatedSession) {
        Session existingSession = sessionRepository.findById(sessionId).orElseThrow((() -> new RuntimeException("Session with id: "+ sessionId + "is not found")));
        if (existingSession != null) {
            existingSession.setSessionId(updatedSession.getSessionId());
            existingSession.setDate(updatedSession.getDate());
            existingSession.setGrade(updatedSession.getGrade());
            existingSession.setAttendance(updatedSession.isAttendance());
            return sessionRepository.save(existingSession);
        }
        return null;
    }

}

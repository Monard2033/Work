package com.example.IBMProject.services;
import com.example.IBMProject.entities.Session;
import com.example.IBMProject.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session getSessionById(int sessionId) {
        return sessionRepository.findById(sessionId).orElse(null);
    }
}

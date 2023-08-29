package com.student.ibmproject.controllers;
import com.student.ibmproject.entities.Session;
import com.student.ibmproject.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Session>> getAllSessions() {
        List<Session> sessions = sessionService.getAllSessions();
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Session> addSession(@RequestBody Session session) {
        Session addedSession = sessionService.createSession(session);
        return new ResponseEntity<>(addedSession, HttpStatus.CREATED);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable int sessionId) {
        Session session = sessionService.getSessionById(sessionId);
        if (session != null) {
            return new ResponseEntity<>(session, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<String> deleteSession(@PathVariable int sessionId) {
        Session session = sessionService.getSessionById(sessionId);
        if (session != null) {
            sessionService.deleteSession(sessionId);
            return new ResponseEntity<>("Session with ID " + sessionId + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Session with ID " + sessionId + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{sessionId}")
    public ResponseEntity<Session> updateSession(@PathVariable int sessionId, @RequestBody Session updatedSession) {
        Session session = sessionService.getSessionById(sessionId);
        if (session != null) {
            updatedSession.setSessionId(sessionId);
            Session updated = sessionService.updateSession(sessionId,updatedSession);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

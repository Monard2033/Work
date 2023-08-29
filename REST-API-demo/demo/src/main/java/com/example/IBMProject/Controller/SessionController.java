package com.example.IBMProject.Controller;
import com.example.IBMProject.entities.Session;
import com.example.IBMProject.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/create")
    public Session createSession(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    @GetMapping("/get")
    public Session getSessionById(@PathVariable int sessionId) {
        return sessionService.getSessionById(sessionId);
    }
}

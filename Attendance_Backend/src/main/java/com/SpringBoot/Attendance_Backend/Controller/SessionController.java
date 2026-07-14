package com.SpringBoot.Attendance_Backend.Controller;

import com.SpringBoot.Attendance_Backend.Entity.Session;
import com.SpringBoot.Attendance_Backend.Service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping("/sessions")
    public ResponseEntity<Session> CreateSession(@RequestBody Session session){
        Session created=sessionService.CreateSession(session);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/sessions")
    ResponseEntity<List<Session>> GetAllSessions(){
        List sessions=sessionService.GetAllSessions();
        return ResponseEntity.ok(sessions);
    }
}

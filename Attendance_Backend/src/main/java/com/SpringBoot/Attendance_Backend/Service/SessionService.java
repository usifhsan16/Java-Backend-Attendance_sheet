package com.SpringBoot.Attendance_Backend.Service;

import com.SpringBoot.Attendance_Backend.Entity.Session;
import com.SpringBoot.Attendance_Backend.Repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public Session CreateSession(Session session) {
        return sessionRepository.save(session);
    }

    public List<Session> GetAllSessions(){
        return sessionRepository.findAll();
    }
}

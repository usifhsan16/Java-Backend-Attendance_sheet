package com.SpringBoot.Attendance_Backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "Session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SessionId;
    @NotBlank
    private String Title;
    @NotBlank
    private LocalDate SessionDate;

    public Long getSessionId() {
        return SessionId;
    }

    public void setSessionId(Long sessionId) {
        SessionId = sessionId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public LocalDate getSessionDate() {
        return SessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        SessionDate = sessionDate;
    }
}

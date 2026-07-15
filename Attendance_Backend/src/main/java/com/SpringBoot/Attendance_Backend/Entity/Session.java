package com.SpringBoot.Attendance_Backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "Session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SessionId;

    @NotBlank
    private String Title;

    @NotNull
    private LocalDate SessionDate;

    @JsonProperty("id")
    public Long getSessionId() {
        return SessionId;
    }

    public void setSessionId(Long sessionId) {
        SessionId = sessionId;
    }

    @JsonProperty("name")
    public String getTitle() {
        return Title;
    }

    @JsonProperty("name")
    public void setTitle(String title) {
        Title = title;
    }

    @JsonProperty("date")
    public LocalDate getSessionDate() {
        return SessionDate;
    }

    @JsonProperty("date")
    public void setSessionDate(LocalDate sessionDate) {
        SessionDate = sessionDate;
    }
}
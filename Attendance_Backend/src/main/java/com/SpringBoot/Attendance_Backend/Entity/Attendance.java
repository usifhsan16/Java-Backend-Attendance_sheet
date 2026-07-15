package com.SpringBoot.Attendance_Backend.Entity;

import com.SpringBoot.Attendance_Backend.Enums.AttendanceStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AttendanceId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    @ManyToOne
    @JoinColumn(name = "session_id")
    @JsonIgnore
    private Session session;

    @JsonProperty("id")
    public Long getAttendanceId() {
        return AttendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        AttendanceId = attendanceId;
    }

    @JsonProperty("status")
    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    @JsonProperty("status")
    public void setAttendanceStatus(AttendanceStatus attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    // These are what actually get serialized to JSON as "memberId" / "sessionId"
    @JsonProperty("memberId")
    public Long getMemberId() {
        return member != null ? member.getMemberId() : null;
    }

    @JsonProperty("memberId")
    public void setMemberId(Long memberId) {
        if (memberId != null) {
            Member m = new Member();
            m.setMemberId(memberId);
            this.member = m;
        }
    }

    @JsonProperty("sessionId")
    public Long getSessionId() {
        return session != null ? session.getSessionId() : null;
    }

    @JsonProperty("sessionId")
    public void setSessionId(Long sessionId) {
        if (sessionId != null) {
            Session s = new Session();
            s.setSessionId(sessionId);
            this.session = s;
        }
    }
}
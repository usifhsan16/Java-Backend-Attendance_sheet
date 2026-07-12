package com.SpringBoot.Attendance_Backend.Entity;

import com.SpringBoot.Attendance_Backend.Enums.AttendanceStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AttendanceId;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;

    public Long getAttendanceId() {
        return AttendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        AttendanceId = attendanceId;
    }

    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(AttendanceStatus attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
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

    @OneToOne
    @JoinColumn(name = "Member Id")
    private Member member;
    @OneToOne
    @JoinColumn(name = "Session Id")
    private Session session;
}

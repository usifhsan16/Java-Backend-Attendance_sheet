package com.SpringBoot.Attendance_Backend.Service;

import com.SpringBoot.Attendance_Backend.Entity.Attendance;
import com.SpringBoot.Attendance_Backend.Entity.Member;
import com.SpringBoot.Attendance_Backend.Entity.Session;
import com.SpringBoot.Attendance_Backend.Repository.AttendanceRepository;
import com.SpringBoot.Attendance_Backend.Repository.MemberRepository;
import com.SpringBoot.Attendance_Backend.Repository.SessionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final MemberRepository memberRepository;
    private final SessionRepository sessionRepository;

    public Attendance MarkAttendance(Attendance request) {

        // 1. Look up the real Member and Session using the raw IDs from the request
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new EntityNotFoundException("Member not found: " + request.getMemberId()));

        Session session = sessionRepository.findById(request.getSessionId())
                .orElseThrow(() -> new EntityNotFoundException("Session not found: " + request.getSessionId()));

        // 2. Search using the raw IDs, NOT attendance.getMemberId()/getSessionId()
        Optional<Attendance> existing = attendanceRepository
                .findByMember_MemberIdAndSession_SessionId(request.getMemberId(), request.getSessionId());
        Attendance attendance = existing.orElseGet(Attendance::new);
        attendance.setMember(member);
        attendance.setSession(session);
        attendance.setAttendanceStatus(request.getAttendanceStatus());
        attendance.setNotes(request.getNotes());

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> GetAttendanceForMember(Long memberId) {
        return attendanceRepository.findByMember_MemberId(memberId);
    }
}

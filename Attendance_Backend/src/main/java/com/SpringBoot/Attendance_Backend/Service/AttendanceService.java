package com.SpringBoot.Attendance_Backend.Service;

import com.SpringBoot.Attendance_Backend.Entity.Attendance;
import com.SpringBoot.Attendance_Backend.Repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public Attendance MarkAttendance(Attendance attendance){
        Optional<Attendance> created= attendanceRepository.
                findByMember_MemberIdAndSession_SessionId
                (attendance.getMemberId(),attendance.getSessionId());
        if (created.isPresent()) {
            Attendance present=created.get();
            present.setAttendanceStatus(attendance.getAttendanceStatus());
            present.setNotes(attendance.getNotes());
            return attendanceRepository.save(present);
        }
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> GetAttendanceForMember(Long memberId) {
        return attendanceRepository.findByMember_MemberId(memberId);
    }
}

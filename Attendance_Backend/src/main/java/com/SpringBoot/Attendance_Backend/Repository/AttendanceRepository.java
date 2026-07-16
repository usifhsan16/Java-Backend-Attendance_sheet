package com.SpringBoot.Attendance_Backend.Repository;

import com.SpringBoot.Attendance_Backend.Entity.Attendance;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

    Optional<Attendance> findByMember_MemberIdAndSession_SessionId(Long memberId, Long sessionId);

    List<Attendance> findByMember_MemberId(Long memberId);

    List<Attendance> findBySession_SessionId(Long sessionId);
}

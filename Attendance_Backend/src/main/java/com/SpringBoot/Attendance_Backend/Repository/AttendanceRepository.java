package com.SpringBoot.Attendance_Backend.Repository;

import com.SpringBoot.Attendance_Backend.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
}

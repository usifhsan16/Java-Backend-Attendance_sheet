package com.SpringBoot.Attendance_Backend.Repository;

import com.SpringBoot.Attendance_Backend.Entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
}

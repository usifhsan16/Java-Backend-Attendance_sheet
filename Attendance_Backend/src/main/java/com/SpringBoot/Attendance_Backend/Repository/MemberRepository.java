package com.SpringBoot.Attendance_Backend.Repository;

import com.SpringBoot.Attendance_Backend.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    public List<Member> findByCategory(String Category);
}

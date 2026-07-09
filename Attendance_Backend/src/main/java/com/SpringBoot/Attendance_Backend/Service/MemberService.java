package com.SpringBoot.Attendance_Backend.Service;

import com.SpringBoot.Attendance_Backend.Entity.Member;
import com.SpringBoot.Attendance_Backend.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> GetAllMembers(){
        return memberRepository.findAll();
    }

    public List<Member> GetMembersByCategory(String Category){
        return memberRepository.fistbycategory(Category);
    }
}

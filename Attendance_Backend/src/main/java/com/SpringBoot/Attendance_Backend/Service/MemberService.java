package com.SpringBoot.Attendance_Backend.Service;

import com.SpringBoot.Attendance_Backend.Entity.Member;
import com.SpringBoot.Attendance_Backend.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> GetAllMembers(){
        return memberRepository.findAll();
    }

    public List<Member> GetMembersByCategory(String Category){
        return memberRepository.findByCategory(Category);
    }

    public Member CreateMember(Member member){
        return memberRepository.save(member);
    }

    public void UpdateMember(Long id, Member Updatedmember) {
        Member member=memberRepository.findById(id).orElse(null);
        if(member!=null){
            member.setName(Updatedmember.getName());
            member.setCategory(Updatedmember.getCategory());
            member.setEmail(Updatedmember.getEmail());
            member.setRole(Updatedmember.getRole());
            memberRepository.save(member);
        }
    }

    public void DeleteMember(Long id){
        Member member=memberRepository.findById(id).orElse(null);
        if (member!=null){
            memberRepository.delete(member);
        }
    }
}

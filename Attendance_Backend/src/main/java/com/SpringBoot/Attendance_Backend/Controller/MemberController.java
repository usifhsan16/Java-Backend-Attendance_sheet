package com.SpringBoot.Attendance_Backend.Controller;

import com.SpringBoot.Attendance_Backend.Entity.Member;
import com.SpringBoot.Attendance_Backend.Service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<Member>> AllMembers(){
        List members=memberService.GetAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/members/category/{category}")
    public ResponseEntity<List<Member>> GetMembersByCategory(@PathVariable String Category){
        List members=memberService.GetMembersByCategory(Category);
        return ResponseEntity.ok(members);
    }

    @PostMapping("/members")
    public ResponseEntity<Void> CreateMember(@Valid @RequestBody Member member){
        memberService.CreateMember(member);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Void> UpdateMember(@PathVariable Long id,@RequestBody Member member){
        memberService.UpdateMember(id,member);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> DeleteMember(@PathVariable Long id){
        memberService.DeleteMember(id);
        return ResponseEntity.noContent().build();
    }
}

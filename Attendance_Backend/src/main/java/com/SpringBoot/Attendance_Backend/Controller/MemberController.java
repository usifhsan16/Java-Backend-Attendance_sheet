package com.SpringBoot.Attendance_Backend.Controller;

import com.SpringBoot.Attendance_Backend.Entity.Member;
import com.SpringBoot.Attendance_Backend.Service.MemberService;
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

    @GetMapping("/members/category")
    public ResponseEntity<List<Member>> GetMembersByCategory(@PathVariable String Category){
        List members=memberService.GetMembersByCategory(Category);
        return ResponseEntity.ok(members);
    }

}

package com.SpringBoot.Attendance_Backend.Controller;

import com.SpringBoot.Attendance_Backend.Entity.Attendance;
import com.SpringBoot.Attendance_Backend.Service.AttendanceService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/attendance")
    public ResponseEntity<Attendance> MarkAttendance(@RequestBody Attendance attendance){
        Attendance returned=attendanceService.MarkAttendance(attendance);
        return ResponseEntity.ok(returned);
    }

    @GetMapping("/attendance/member/{memberId}")
    public ResponseEntity<List<Attendance>> GetAttendanceforMember(@PathVariable Long memberId){
        List AttendanceofMember=attendanceService.GetAttendanceForMember(memberId);
        return ResponseEntity.ok(AttendanceofMember);
    }
}

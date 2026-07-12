package com.SpringBoot.Attendance_Backend.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AttendanceStatus {
    PRESENT,
    ABSENT;
    @JsonCreator
    public static AttendanceStatus fromString(String value) {
        return AttendanceStatus.valueOf(value.toUpperCase());
    }
}

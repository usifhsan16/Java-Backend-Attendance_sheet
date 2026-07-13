package com.SpringBoot.Attendance_Backend.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AttendanceStatus {
    PRESENT,
    ABSENT;
    @JsonCreator
    public static AttendanceStatus fromString(String value) {
        return AttendanceStatus.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }
}

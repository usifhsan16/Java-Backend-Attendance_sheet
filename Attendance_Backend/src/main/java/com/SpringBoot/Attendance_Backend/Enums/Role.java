package com.SpringBoot.Attendance_Backend.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
    ATTENDEE,
    ORGANIZER,
    MEMBER;
    @JsonCreator
    public static Role fromString(String value) {
        return Role.valueOf(value.toUpperCase());
    }
}

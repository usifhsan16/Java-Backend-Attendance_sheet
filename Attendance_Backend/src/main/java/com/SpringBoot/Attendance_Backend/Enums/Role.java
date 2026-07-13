package com.SpringBoot.Attendance_Backend.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ATTENDEE,
    ORGANIZER,
    MEMBER;
    @JsonCreator
    public static Role fromString(String value) {
        return Role.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }
}

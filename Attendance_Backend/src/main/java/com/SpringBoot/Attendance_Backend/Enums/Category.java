package com.SpringBoot.Attendance_Backend.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
    GAME,
    GRAPHICS;

    @JsonCreator
    public static Category fromString(String value) {
        return Category.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }
}

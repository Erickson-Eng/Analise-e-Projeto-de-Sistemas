package com.hotcatalogo.backend.domain.entity.enums;

public enum ParticipantType {
    AUTHOR("AUTHOR"),
    INTERPRETER("INTERPRETER"),
    PRODUCER("PRODUCER");

    private final String code;

    ParticipantType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

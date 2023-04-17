package com.example.ttestt.data.entity;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("admin"), MANAGER("manager"), USER("user");

    private String value;

    Role(String role) {
        this.value = role;
    }

}

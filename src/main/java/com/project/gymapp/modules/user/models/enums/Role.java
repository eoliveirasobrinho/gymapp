package com.project.gymapp.modules.user.models.enums;

public enum Role {
    ADMIN("admin"), CUSTOMER("customer"), EMPLOYEE("employee"), MANAGEMENT("management");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}

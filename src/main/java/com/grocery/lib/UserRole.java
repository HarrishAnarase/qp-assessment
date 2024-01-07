package com.grocery.lib;

import java.util.HashMap;
import java.util.Map;

/**
 * ENUM defines user role
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
public enum UserRole {
    ADMIN("admin"), USER("user");
    private final String value;

    UserRole(String roleValue) {
        this.value = roleValue;
    }

    private static final Map<String, UserRole> lookup = new HashMap<String, UserRole>();
    static {
        for (UserRole userRole : UserRole.values()) {
            lookup.put(userRole.getValue(), userRole);
        }

    }
    public String getValue() {
        return value;
    }

    public static UserRole getStaffRole(String userRoleValue) {
        return lookup.get(userRoleValue);
    }
}

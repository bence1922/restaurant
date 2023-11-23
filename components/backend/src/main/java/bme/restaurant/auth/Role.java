package bme.restaurant.auth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Role {
    admin(new HashSet<>(Arrays.asList(
        "default", 
        "employee-read", 
        "employee-write",
        "table-read",
        "table-write",
        "table-delete",
        "booking-read",
        "booking-write",
        "booking-status-update"
        ))),
    employee(new HashSet<>(Arrays.asList(
        "default", 
        "table-read",
        "table-write",
        "table-delete",
        "booking-read",
        "booking-write",
        "booking-status-update"
        ))),
    customer(new HashSet<>(Arrays.asList(
        "default", 
        "booking-read",
        "booking-write"
        )));

    private final Set<String> permissions;

    Role(Set<String> permissions) {
        this.permissions = permissions;
    }

    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }
}
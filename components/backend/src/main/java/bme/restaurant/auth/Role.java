package bme.restaurant.auth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Role {
    admin(new HashSet<>(Arrays.asList(
            "default",
            "employee-read",
            "employee-write",
            "employee-list",
            "emloyee-register",
            "table-read",
            "table-write",
            "table-delete",
            "booking-read",
            "booking-read-all",
            "booking-write",
            "booking-status-update",
            "table-order-read",
            "table-order-write",
            "customer-read",
            "table-order-read",
            "table-order-write",
            "customer-order-read",
            "customer-order-write"))),
    employee(new HashSet<>(Arrays.asList(
            "default",
            "table-read",
            "table-write",
            "table-delete",
            "booking-read",
            "booking-read-all",
            "booking-write",
            "booking-status-update",
            "table-order-read",
            "table-order-write",
            "customer-read",
            "table-order-read",
            "table-order-write",
            "customer-order-read",
            "customer-order-write"))),
    customer(new HashSet<>(Arrays.asList(
            "default",
            "booking-read",
            "booking-write",
            "customer-read-self",
            "customer-order-write")));

    private final Set<String> permissions;

    Role(Set<String> permissions) {
        this.permissions = permissions;
    }

    public boolean hasPermission(String permission) {
        return permissions.contains(permission);
    }
}
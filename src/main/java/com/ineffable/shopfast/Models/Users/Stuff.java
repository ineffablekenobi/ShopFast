package com.ineffable.shopfast.Models.Users;

public class Stuff extends User {

    String Role;

    public Stuff(Long id, String username, String password, String email, String role) {
        super(id, username, password, email);
        Role = role;
    }

    public Stuff(String role) {
        Role = role;
    }

    public Stuff(Long id, String username, String password, String email) {
        super(id, username, password, email);
    }

    public Stuff() {
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

}

package com.example.springjpa.model;

import com.example.springjpa.model.User;
import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String fullName;

    public UserDto(int id, String email, String password, String fullName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public UserDto(User u) {
        this.id = u.getId();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.fullName = u.getFullName();
    }
}

package com.example.springjpa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    private int id;
    private String email;
    private String password;
    private String fullName;

    public User(int id, String email, String password, String fullName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public User() {

    }

    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.fullName = userDto.getFullName();
    }
}

package org.example.restreservation.entity.dto.request;


import org.example.restreservation.entity.User;


public record CreateUserRequest(String name, Long phone, String email) {
    public User toEntity(){
        return new User(name, phone, email);
    }
}


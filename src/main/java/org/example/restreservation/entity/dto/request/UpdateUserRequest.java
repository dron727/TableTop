package org.example.restreservation.entity.dto.request;

import org.example.restreservation.entity.User;

public class UpdateUserRequest {
    String name;
    Long phone;
    String email;

    public UpdateUserRequest(String name, Long phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Long getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public User toEntity(Long id){
        return new User(id, name, phone, email);
    }
}

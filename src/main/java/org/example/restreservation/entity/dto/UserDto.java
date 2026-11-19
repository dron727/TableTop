package org.example.restreservation.entity.dto;

public class UserDto {
    private String name;
    private Long phone;
    private String email;

    public UserDto(String name, Long phone, String email) {
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
}

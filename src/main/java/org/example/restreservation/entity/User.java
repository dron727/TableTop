package org.example.restreservation.entity;

import jakarta.persistence.*;
import org.example.restreservation.entity.dto.UserDto;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @Column(name = "email")
    private String email;

    public User(String name, Long phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public User(Long id, String name, Long phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public User(){
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

    public Long getId(){
        return id;
    }

    public UserDto toDto(){
        return new UserDto(name, phone, email);
    }
}

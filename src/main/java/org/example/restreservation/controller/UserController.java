package org.example.restreservation.controller;

import org.example.restreservation.entity.dto.UserContainerDto;
import org.example.restreservation.entity.dto.UserDto;
import org.example.restreservation.entity.dto.request.CreateUserRequest;
import org.example.restreservation.entity.dto.request.UpdateUserRequest;
import org.example.restreservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get")
    public UserContainerDto getAll(){
        return userService.findAll();
    }

    @GetMapping("/get/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/add")
    public UserDto save(@RequestBody CreateUserRequest request){
        return userService.save(request);
    }

    @PutMapping("/update/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UpdateUserRequest request){
        return userService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}

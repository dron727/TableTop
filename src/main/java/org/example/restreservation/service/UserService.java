package org.example.restreservation.service;

import jakarta.transaction.Transactional;
import org.example.restreservation.entity.User;
import org.example.restreservation.entity.dto.UserContainerDto;
import org.example.restreservation.entity.dto.UserDto;
import org.example.restreservation.entity.dto.request.CreateUserRequest;
import org.example.restreservation.entity.dto.request.UpdateUserRequest;
import org.example.restreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserContainerDto findAll(){
        List<UserDto> userDtoList = userRepository.findAll().stream()
                .map(User::toDto)
                .collect(Collectors.toList());
        return new UserContainerDto(userDtoList);
    }

    public UserDto findById(Long id){
        return userRepository.findById(id)
                .map(User::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Не нашли по id"));
    }

    public UserDto save(CreateUserRequest request){
        User user = request.toEntity();
        return userRepository.save(user).toDto();
    }

    public UserDto update(Long id, UpdateUserRequest request){
        return userRepository.findById(id)
                .map(existingUser -> {
                    User user = request.toEntity(existingUser.getId());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new IllegalArgumentException("Не нашли по id")).toDto();
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}

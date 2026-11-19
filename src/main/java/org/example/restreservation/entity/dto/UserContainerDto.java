package org.example.restreservation.entity.dto;

import java.util.List;

public class UserContainerDto {
    private final List<UserDto> userDtoList;

    public UserContainerDto(List<UserDto> userDtoList){
        this.userDtoList = userDtoList;
    }

    public List<UserDto> getUserDtoList(){
        return userDtoList;
    }
}

package com.example.ttestt.data.mapping;

import com.example.ttestt.data.dto.UsersDto;
import com.example.ttestt.data.entity.Users;

public class UsersMapping {
    public static Users convertToUser(UsersDto dto) {
        Users user = new Users().builder()
                .userId(dto.getUsersId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();

        return user;
    }

    public static UsersDto convertToDto(Users users) {
        UsersDto usersDto = new UsersDto().builder()
                .usersId(users.getUserId())
                .username(users.getUsername())
                .password(users.getPassword())
                .email(users.getEmail())
                .role(users.getRole())
                .build();

        return usersDto;
    }
}

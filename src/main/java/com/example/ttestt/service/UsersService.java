package com.example.ttestt.service;

import com.example.ttestt.data.dto.UsersDto;
import com.example.ttestt.data.entity.Users;

public interface UsersService {

    public UsersDto getUsers(Long id);

    public UsersDto postUsers(Users users);

    public UsersDto updateUsers(Long id, UsersDto usersDto);

    public void deleteUsers(Long id);

}

package com.example.spring_security_test.service;

import com.example.spring_security_test.data.dto.UsersDto;
import com.example.spring_security_test.data.entity.Users;

public interface UsersService {

    public UsersDto getUsers(Long id);

    public UsersDto postUsers(Users users);

    public UsersDto updateUsers(Long id, UsersDto usersDto);

    public void deleteUsers(Long id);

}

package com.example.ttestt.service.impl;

import com.example.ttestt.data.dto.UsersDto;
import com.example.ttestt.data.entity.Role;
import com.example.ttestt.data.entity.Users;
import com.example.ttestt.data.mapping.UsersMapping;
import com.example.ttestt.data.repository.UsersRepository;
import com.example.ttestt.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UsersDto getUsers(Long id) {

        return UsersMapping.convertToDto(findUser(id));
    }

    @Override
    public UsersDto postUsers(Users users) {
        users.setRole(Role.USER);
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
        Users user = usersRepository.findByUsername(users.getUsername()).orElseThrow(()->{
            throw new IllegalArgumentException(String.format("Users에서 userName : %s 를 찾을 수 없습니다.", users.getUsername()));
        });

        return UsersMapping.convertToDto(user);
    }

    @Override
    @Transactional
    public UsersDto updateUsers(Long id, UsersDto requestUserDto) {
        Users user = findUser(id);
        user.setPassword(requestUserDto.getPassword());
        user.setEmail(requestUserDto.getEmail());

        return UsersMapping.convertToDto(user);
    }

    @Override
    public void deleteUsers(Long id) {
        Users user = findUser(id);
        usersRepository.delete(user);
    }

    private Users findUser(Long id) {
        Optional<Users> users = usersRepository.findById(id);
        if (users.isEmpty()) { throw new IllegalArgumentException(String.format("Users에서 id : %s 를 찾을 수 없습니다.", id)); }
        return users.get();
    }
}

package com.example.spring_security_test.service.impl;

import com.example.spring_security_test.data.dto.UsersDto;
import com.example.spring_security_test.data.entity.Role;
import com.example.spring_security_test.data.entity.Users;
import com.example.spring_security_test.data.mapping.UsersMapping;
import com.example.spring_security_test.data.repository.UsersRepository;
import com.example.spring_security_test.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;

    private final Logger LOGGER = LoggerFactory.getLogger(UsersServiceImpl.class);


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
        Users updateUser = findUser(id);
        updateUser.setPassword(bCryptPasswordEncoder.encode(requestUserDto.getPassword()));
        updateUser.setEmail(requestUserDto.getEmail());

        usersRepository.save(updateUser);

        LOGGER.info("user update 완료");

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(updateUser.getUsername(), requestUserDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        LOGGER.info("Context Authentication 변경 완료");

        return UsersMapping.convertToDto(updateUser);
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

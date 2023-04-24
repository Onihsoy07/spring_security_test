package com.example.spring_security_test.controller.api;

import com.example.spring_security_test.data.dto.UsersDto;
import com.example.spring_security_test.data.entity.Users;
import com.example.spring_security_test.data.mapping.UsersMapping;
import com.example.spring_security_test.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UsersApiController {

    private final Logger LOGGER = LoggerFactory.getLogger(UsersApiController.class);

    private final UsersService usersService;

    @PostMapping("/auth/joinProc")
    public ResponseEntity<UsersDto> join(@RequestBody Users users) {
        LOGGER.info("[post] /api/user/join 실행");
        UsersDto dto = usersService.postUsers(users);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UsersDto> getUsers(@PathVariable final Long id) {
        LOGGER.info("[get] /api/user/{} 실행", id);
        UsersDto dto = usersService.getUsers(id);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/user")
    public ResponseEntity<UsersDto> postUsers(@RequestBody final UsersDto usersDto) {
        LOGGER.info("[post] api/user 실행");
        Users users = UsersMapping.convertToUser(usersDto);
        UsersDto dto = usersService.postUsers(users);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UsersDto> updateUsers(@PathVariable final Long id,
                                                @RequestBody final UsersDto usersDto) {
        LOGGER.info("[put] api/user/{} 실행", id);
        UsersDto dto = usersService.updateUsers(id, usersDto);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Integer> deleteUsers(@PathVariable final Long id) {
        LOGGER.info("[delete] api/user/{} 실행", id);
        usersService.deleteUsers(id);
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }

}

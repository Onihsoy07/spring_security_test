package com.example.spring_security_test.data.dto;

import com.example.spring_security_test.data.entity.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDto {
    private Long usersId;

    private String username;

    private String password;

    private String email;

    private Role role;
}

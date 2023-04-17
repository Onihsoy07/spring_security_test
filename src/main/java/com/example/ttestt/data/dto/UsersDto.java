package com.example.ttestt.data.dto;

import com.example.ttestt.data.entity.Role;
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

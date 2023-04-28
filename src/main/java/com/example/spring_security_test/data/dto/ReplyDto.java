package com.example.spring_security_test.data.dto;

import com.example.spring_security_test.data.entity.Board;
import com.example.spring_security_test.data.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDto {

    private Long id;

    private String comment;

    private Users users;

    private Board board;

}

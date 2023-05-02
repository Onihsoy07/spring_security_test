package com.example.spring_security_test.service;

import com.example.spring_security_test.data.dto.ReplyDto;
import com.example.spring_security_test.data.entity.Users;

public interface ReplyService {

    void save(ReplyDto replyDto, Long boardId, Users users);

}

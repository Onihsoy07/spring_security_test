package com.example.spring_security_test.service.impl;

import com.example.spring_security_test.data.dto.ReplyDto;
import com.example.spring_security_test.data.entity.Reply;
import com.example.spring_security_test.data.repository.ReplyRepository;
import com.example.spring_security_test.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    @Override
    public void save(ReplyDto replyDto) {
        Reply reply = new Reply().builder()
                .comment(replyDto.getComment())
                .build();
        replyRepository.save(reply);
    }
}

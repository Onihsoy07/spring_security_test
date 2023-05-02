package com.example.spring_security_test.service.impl;

import com.example.spring_security_test.data.dto.ReplyDto;
import com.example.spring_security_test.data.entity.Board;
import com.example.spring_security_test.data.entity.Reply;
import com.example.spring_security_test.data.entity.Users;
import com.example.spring_security_test.data.repository.BoardRepository;
import com.example.spring_security_test.data.repository.ReplyRepository;
import com.example.spring_security_test.data.repository.UsersRepository;
import com.example.spring_security_test.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    private final UsersRepository usersRepository;

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public void save(ReplyDto replyDto, Long boardId, Users users) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> {
            throw new IllegalArgumentException(String.format("Board에서 id : %d 를 찾을 수 없습니다.", boardId));
        });

        Reply reply = new Reply().builder()
                .comment(replyDto.getComment())
                .users(users)
                .board(board)
                .build();
        replyRepository.save(reply);
    }
}

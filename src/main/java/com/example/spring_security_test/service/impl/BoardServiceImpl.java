package com.example.spring_security_test.service.impl;

import com.example.spring_security_test.data.entity.Board;
import com.example.spring_security_test.data.entity.Users;
import com.example.spring_security_test.data.repository.BoardRepository;
import com.example.spring_security_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public void writeBoard(Board board, Users users) {
        board.setViewCount(0);
        board.setUsers(users);
        boardRepository.save(board);
    }

}

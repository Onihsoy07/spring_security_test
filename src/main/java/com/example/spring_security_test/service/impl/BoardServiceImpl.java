package com.example.spring_security_test.service.impl;

import com.example.spring_security_test.data.dto.BoardDto;
import com.example.spring_security_test.data.entity.Board;
import com.example.spring_security_test.data.entity.Users;
import com.example.spring_security_test.data.mapping.BoardMapping;
import com.example.spring_security_test.data.repository.BoardRepository;
import com.example.spring_security_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional(readOnly = true)
    public Page<Board> mainBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public BoardDto getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(String.format("Board ID : %d 로 찾을 수 없습니다.", id));
                });
        return BoardMapping.convertToDto(board);
    }

    @Override
    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}

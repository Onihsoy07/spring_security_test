package com.example.spring_security_test.service.impl;

import com.example.spring_security_test.data.dto.BoardDto;
import com.example.spring_security_test.data.entity.Board;
import com.example.spring_security_test.data.entity.Users;
import com.example.spring_security_test.data.mapping.BoardMapping;
import com.example.spring_security_test.data.repository.BoardRepository;
import com.example.spring_security_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

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
//        boardRepository.deleteById(id);
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(String.format("Board ID : %d 로 찾을 수 없습니다.", id));
                });
        LOGGER.info("Board ID : {} 삭제 중", id);
        boardRepository.delete(board);
        LOGGER.info("Board ID : {} 삭제 완료", id);
    }
}

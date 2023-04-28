package com.example.spring_security_test.service;

import com.example.spring_security_test.data.dto.BoardDto;
import com.example.spring_security_test.data.entity.Board;
import com.example.spring_security_test.data.entity.Reply;
import com.example.spring_security_test.data.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    void writeBoard(Board board, Users users);

    Page<Board> mainBoardList(Pageable pageable);

    BoardDto getBoard(Long id);

    void deleteBoard(Long id);

    List<Reply> viewReply(Long id);

    void updateBoard(Long id, BoardDto boardDto);

}
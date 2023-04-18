package com.example.spring_security_test.service;

import com.example.spring_security_test.data.entity.Board;
import com.example.spring_security_test.data.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    void writeBoard(Board board, Users users);

    Page<Board> mainBoardList(Pageable pageable);

}

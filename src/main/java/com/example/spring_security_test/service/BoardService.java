package com.example.spring_security_test.service;

import com.example.spring_security_test.data.entity.Board;
import com.example.spring_security_test.data.entity.Users;

public interface BoardService {

    void writeBoard(Board board, Users users);

}

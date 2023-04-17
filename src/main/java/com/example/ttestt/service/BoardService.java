package com.example.ttestt.service;

import com.example.ttestt.data.entity.Board;
import com.example.ttestt.data.entity.Users;

public interface BoardService {

    void writeBoard(Board board, Users users);

}

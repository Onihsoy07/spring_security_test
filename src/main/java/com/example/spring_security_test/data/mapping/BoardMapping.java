package com.example.spring_security_test.data.mapping;

import com.example.spring_security_test.data.dto.BoardDto;
import com.example.spring_security_test.data.entity.Board;

public class BoardMapping {

    public static BoardDto convertToDto(Board board) {
        BoardDto dto = new BoardDto().builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .viewCount(board.getViewCount())
                .users(board.getUsers())
                .replyList(board.getReplyList())
                .build();
        return dto;
    }

    public static Board convertToModel(BoardDto dto) {
        Board board = new Board().builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .viewCount(dto.getViewCount())
                .users(dto.getUsers())
                .replyList(dto.getReplyList())
                .build();
        return board;
    }

}

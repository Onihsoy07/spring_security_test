package com.example.ttestt.controller.api;

import com.example.ttestt.config.auth.PrincipalDetail;
import com.example.ttestt.data.entity.Board;
import com.example.ttestt.data.entity.Users;
import com.example.ttestt.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class BoardApiController {

    private final BoardService boardService;

    private final Logger LOGGER = LoggerFactory.getLogger(BoardApiController.class);

    @PostMapping("/board")
    public ResponseEntity<Integer> writeBoard(@RequestBody final Board board,
                                             @AuthenticationPrincipal final PrincipalDetail principal) {
        LOGGER.info("[post] /api/board 호출");
        boardService.writeBoard(board, principal.getUsers());
        LOGGER.info("[post] /api/board 완료");
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }

}

package com.example.spring_security_test.controller.api;

import com.example.spring_security_test.config.auth.PrincipalDetail;
import com.example.spring_security_test.data.entity.Board;
import com.example.spring_security_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<Integer> deleteBoard(@PathVariable final Long id) {
        LOGGER.info("[delete] /api/board/{} 호출", id);
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }

}

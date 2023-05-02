package com.example.spring_security_test.controller.api;

import com.example.spring_security_test.config.auth.PrincipalDetail;
import com.example.spring_security_test.data.dto.ReplyDto;
import com.example.spring_security_test.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReplyApiController {

    private final ReplyService replyService;

    private final Logger LOGGER = LoggerFactory.getLogger(ReplyApiController.class);

    @PostMapping("/reply/board/{id}")
    public ResponseEntity<Integer> replySave(@PathVariable final Long id,
                                             @RequestBody final ReplyDto replyDto,
                                             @AuthenticationPrincipal final PrincipalDetail principal) {
        LOGGER.info("boarID {} ,   userId {}", id, principal.getUsers().getUserId());
        replyService.save(replyDto, id, principal.getUsers());
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }

}

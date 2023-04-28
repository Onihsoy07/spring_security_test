package com.example.spring_security_test.controller.api;

import com.example.spring_security_test.data.dto.ReplyDto;
import com.example.spring_security_test.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReplyApiController {

    private final ReplyService replyService;

    private final Logger LOGGER = LoggerFactory.getLogger(ReplyApiController.class);

    @PostMapping("/reply")
    public ResponseEntity<Integer> replySave(@RequestBody final ReplyDto replyDto) {
        replyService.save(replyDto);
        return ResponseEntity.status(HttpStatus.OK).body(1);
    }

}

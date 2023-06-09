package com.example.spring_security_test.controller;

import com.example.spring_security_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping({"", "/", "/main"})
    public String index(Model model,
                        @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.mainBoardList(pageable));
        return "index";
    }

    @GetMapping("/board/writeForm")
    public String board() {
        return "board/writeForm";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable final Long id,
                         Model model) {
        model.addAttribute("board", boardService.getBoard(id));
        return "board/detail";
    }

    @GetMapping("board/updateForm/{id}")
    public String updateForm(@PathVariable final Long id,
                             Model model) {
        model.addAttribute("board", boardService.getBoard(id));
        return "board/updateForm";
    }

}

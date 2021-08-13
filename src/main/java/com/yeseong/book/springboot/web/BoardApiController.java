package com.yeseong.book.springboot.web;

import com.yeseong.book.springboot.domain.BaseTimeEntity;
import com.yeseong.book.springboot.service.board.BoardService;
import com.yeseong.book.springboot.web.dto.BoardResponseDto;
import com.yeseong.book.springboot.web.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController extends BaseTimeEntity {

    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(requestDto);
    }

    @GetMapping("/api/v1/board/{id}")
    public BoardResponseDto findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

}

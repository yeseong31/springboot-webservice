package com.yeseong.book.springboot.service.board;

import com.yeseong.book.springboot.domain.board.Board;
import com.yeseong.book.springboot.domain.board.BoardRepository;
import com.yeseong.book.springboot.web.dto.BoardListResponseDto;
import com.yeseong.book.springboot.web.dto.BoardResponseDto;
import com.yeseong.book.springboot.web.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 데이터가 없음... id=" + id));
        return new BoardResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAll() {
        return boardRepository.findAll().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
    }

}

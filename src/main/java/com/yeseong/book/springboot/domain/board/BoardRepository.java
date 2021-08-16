package com.yeseong.book.springboot.domain.board;

import com.yeseong.book.springboot.web.dto.BoardListResponseDto;
import com.yeseong.book.springboot.web.dto.BoardResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b FROM Board b ORDER BY b.id DESC")
    List<Board> findAll();

    @Query("select b from Board b where b.ccd like '%keyword%'")
    BoardListResponseDto findByKeyword(@Param("keyword") String keyword);

}

package com.yeseong.book.springboot.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 정렬 조건을 다르게 해서 페이지에 '순위'대로 표시될 수 있도록 해야 함
    @Query("SELECT b FROM Board b ORDER BY b.id")
    List<Board> findAll();

}

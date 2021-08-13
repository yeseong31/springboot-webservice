package com.yeseong.book.springboot.domain.posts;

import com.yeseong.book.springboot.domain.board.Board;
import com.yeseong.book.springboot.domain.board.BoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @AfterEach
    public void cleanup() {
        boardRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String ccd = "테스트-시군구";
        String houseNum = "테스트-번지";

        boardRepository.save(Board.builder()
                .ccd(ccd)
                .houseNum(houseNum)
                .build());

        // when
        List<Board> boardList = boardRepository.findAll();

        // then
        Board board = boardList.get(0);
        assertThat(board.getCcd()).isEqualTo(ccd);
        assertThat(board.getHouseNum()).isEqualTo(houseNum);
    }


}

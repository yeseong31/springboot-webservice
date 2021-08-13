package com.yeseong.book.springboot.domain.posts;

import com.yeseong.book.springboot.domain.board.Board;
import com.yeseong.book.springboot.domain.board.BoardRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @After
    public void cleanup() {
        boardRepository.deleteAll();
    }

    @Test
    public void DB_저장_불러오기() {
        // given
        String ccd = "경기도 부천시";
        String houseNum = "0000";
        String mainNum = "0000";
        String secondaryNum = "0000";
        String complexName = "연화마을대원아파트";       // 이하 생략...

        boardRepository.save(Board.builder()
                        .ccd(ccd)
                        .houseNum(houseNum)
                        .mainNum(mainNum)
                        .secondaryNum(secondaryNum)
                        .complexName(complexName)
                .build());

        // when
        List<Board> boardList = boardRepository.findAll();

        // then
        Board board = boardList.get(0);
        assertThat(board.getCcd()).isEqualTo(ccd);
        assertThat(board.getHouseNum()).isEqualTo(houseNum);
        assertThat(board.getMainNum()).isEqualTo(mainNum);
        assertThat(board.getSecondaryNum()).isEqualTo(secondaryNum);
        assertThat(board.getComplexName()).isEqualTo(complexName);
    }

}

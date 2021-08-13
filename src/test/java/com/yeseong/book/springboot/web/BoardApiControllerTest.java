package com.yeseong.book.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeseong.book.springboot.domain.board.Board;
import com.yeseong.book.springboot.domain.board.BoardRepository;
import com.yeseong.book.springboot.web.dto.BoardSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach                 // (1)
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        boardRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="USER")
    public void Board_등록된다() throws Exception {
        // given
        String ccd = "ccd";
        String houseNum = "houseNum";
        String mainNum = "mainNum";
        String secondaryNum = "secondaryNum";
        String complexName = "complexName";
        String roadName = "roadName";
        double dedicatedArea = 100.0;
        int contractYearMonth = 199807;
        int contractDay = 31;
        int transactionAmount = 100;
        int floor = 1;
        int buildingYear = 1998;

        BoardSaveRequestDto requestDto = BoardSaveRequestDto.builder()
                .ccd(ccd)
                .houseNum(houseNum)
                .mainNum(mainNum)
                .secondaryNum(secondaryNum)
                .complexName(complexName)
                .dedicatedArea(dedicatedArea)
                .contractYearMonth(contractYearMonth)
                .contractDay(contractDay)
                .transactionAmount(transactionAmount)
                .floor(floor)
                .buildingYear(buildingYear)
                .roadName(roadName)
                .build();

        String url = "http://localhost:" + port + "/api/v1/board";

        // when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        // then
        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getCcd()).isEqualTo(ccd);
        assertThat(all.get(0).getHouseNum()).isEqualTo(houseNum);
        assertThat(all.get(0).getMainNum()).isEqualTo(mainNum);
        assertThat(all.get(0).getSecondaryNum()).isEqualTo(secondaryNum);
        assertThat(all.get(0).getComplexName()).isEqualTo(complexName);
        assertThat(all.get(0).getRoadName()).isEqualTo(roadName);
        assertThat(all.get(0).getDedicatedArea()).isEqualTo(dedicatedArea);
        assertThat(all.get(0).getContractYearMonth()).isEqualTo(contractYearMonth);
        assertThat(all.get(0).getContractDay()).isEqualTo(contractDay);
        assertThat(all.get(0).getTransactionAmount()).isEqualTo(transactionAmount);
        assertThat(all.get(0).getFloor()).isEqualTo(floor);
        assertThat(all.get(0).getBuildingYear()).isEqualTo(buildingYear);
    }

}

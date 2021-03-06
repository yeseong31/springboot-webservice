package com.yeseong.book.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeseong.book.springboot.domain.board.Board;
import com.yeseong.book.springboot.domain.board.BoardRepository;
import com.yeseong.book.springboot.web.dto.BoardSaveRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
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

    @Before                 // (1)
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        // boardRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="USER")
    public void Board_????????????() throws Exception {
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
        int idx = all.size() - 1;
        assertThat(all.get(idx).getCcd()).isEqualTo(ccd);
        assertThat(all.get(idx).getHouseNum()).isEqualTo(houseNum);
        assertThat(all.get(idx).getMainNum()).isEqualTo(mainNum);
        assertThat(all.get(idx).getSecondaryNum()).isEqualTo(secondaryNum);
        assertThat(all.get(idx).getComplexName()).isEqualTo(complexName);
        assertThat(all.get(idx).getRoadName()).isEqualTo(roadName);
        assertThat(all.get(idx).getDedicatedArea()).isEqualTo(dedicatedArea);
        assertThat(all.get(idx).getContractYearMonth()).isEqualTo(contractYearMonth);
        assertThat(all.get(idx).getContractDay()).isEqualTo(contractDay);
        assertThat(all.get(idx).getTransactionAmount()).isEqualTo(transactionAmount);
        assertThat(all.get(idx).getFloor()).isEqualTo(floor);
        assertThat(all.get(idx).getBuildingYear()).isEqualTo(buildingYear);
    }

}
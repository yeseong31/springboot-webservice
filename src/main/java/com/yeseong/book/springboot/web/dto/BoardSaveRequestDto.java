package com.yeseong.book.springboot.web.dto;

import com.yeseong.book.springboot.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String ccd, houseNum, mainNum, secondaryNum, complexName, roadName;
    private int contractYearMonth, contractDay, transactionAmount, floor, buildingYear, rrod;
    private double dedicatedArea;

    @Builder
    public BoardSaveRequestDto(String ccd, String houseNum, String mainNum, String secondaryNum, String complexName,
                                    double dedicatedArea, int contractYearMonth, int contractDay, int transactionAmount,
                                    int floor, int buildingYear, String roadName, int rrod) {
        this.ccd = ccd;
        this.houseNum = houseNum;
        this.mainNum = mainNum;
        this.secondaryNum = secondaryNum;
        this.complexName = complexName;
        this.dedicatedArea = dedicatedArea;
        this.contractYearMonth = contractYearMonth;
        this.contractDay = contractDay;
        this.transactionAmount = transactionAmount;
        this.floor = floor;
        this.buildingYear = buildingYear;
        this.roadName = roadName;
        this.rrod = rrod;
    }

    public Board toEntity() {
        return Board.builder()
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
                .rrod(rrod)
                .build();
    }

}

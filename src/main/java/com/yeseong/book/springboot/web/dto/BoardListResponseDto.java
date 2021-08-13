package com.yeseong.book.springboot.web.dto;

import com.yeseong.book.springboot.domain.board.Board;
import com.yeseong.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {

    private Long id;
    private String ccd, houseNum, mainNum, secondaryNum, complexName, roadName;
    private int contractYearMonth, contractDay, transactionAmount, floor, buildingYear, rrod;
    private double dedicatedArea;
    private LocalDateTime modifiedDate;

    public BoardListResponseDto(Board entity) {
        this.id = entity.getId();
        this.ccd = entity.getCcd();
        this.houseNum = entity.getHouseNum();
        this.mainNum = entity.getMainNum();
        this.secondaryNum = entity.getSecondaryNum();
        this.complexName = entity.getComplexName();
        this.dedicatedArea = entity.getDedicatedArea();
        this.contractYearMonth = entity.getContractYearMonth();
        this.contractDay = entity.getContractDay();
        this.transactionAmount = entity.getTransactionAmount();
        this.floor = entity.getFloor();
        this.buildingYear = entity.getBuildingYear();
        this.roadName = entity.getRoadName();
        this.rrod = entity.getRrod();
        this.modifiedDate = entity.getModifiedDate();
    }

}

package com.yeseong.book.springboot.domain.board;

import com.yeseong.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "board")
@Entity
public class Board {

    // 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 시군구
    @Column(length = 100)
    private String ccd;

    // 번지
    @Column(length = 26)
    private String houseNum;

    // 본번
    @Column(length = 26)
    private String mainNum;

    // 부번
    @Column(length = 26)
    private String secondaryNum;

    // 단지명
    @Column(length = 100)
    private String complexName;

    // 전용면적
    private double dedicatedArea;
    // 계약년월
    private int contractYearMonth;
    // 계약일
    private int contractDay;
    // 거래금액
    private int transactionAmount;
    // 층
    private int floor;
    // 건축년도
    private int buildingYear;

    // 도로명
    @Column(length = 100)
    private String roadName;
    // 해제사유발생일
    @Column(nullable = true)
    private int rrod;

    @Builder
    public Board(String ccd, String houseNum, String mainNum, String secondaryNum, String complexName,
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

}
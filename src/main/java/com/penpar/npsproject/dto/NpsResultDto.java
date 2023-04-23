package com.penpar.npsproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NpsResultDto {

    private int scoreZero;
    private int scoreOne; // 만족도 0을 선택한 사람 숫자
    private int scoreTwo; // 만족도 1을 선택한 사람 숫자
    private int scoreThree;
    private int scoreFour;
    private int scoreFive;
    private int scoreSix;
    private int scoreSeven;
    private int scoreEight;
    private int scoreNine;
    private int scoreTen;
    private int totalCount; // 전체 사람 숫자
    private double satisfactionResult;

    public NpsResultDto() {}
    
    public NpsResultDto(int scoreZero, int scoreOne, int scoreTwo, int scoreThree, int scoreFour, int scoreFive, int scoreSix,
            int scoreSeven, int scoreEight, int scoreNine, int scoreTen, int totalCount, double satisfactionResult) {
        this.scoreZero = scoreZero;        
        this.scoreOne = scoreOne;
        this.scoreTwo = scoreTwo;
        this.scoreThree = scoreThree;
        this.scoreFour = scoreFour;
        this.scoreFive = scoreFive;
        this.scoreSix = scoreSix;
        this.scoreSeven = scoreSeven;
        this.scoreEight = scoreEight;
        this.scoreNine = scoreNine;
        this.scoreTen = scoreTen;
        this.totalCount = totalCount;
        this.satisfactionResult = satisfactionResult;
    }

    @Override
    public String toString() {
        return "NpsResultDto [scoreZero=" + scoreZero + ", scoreOne=" + scoreOne + ", scoreTwo=" + scoreTwo + ", scoreThree=" + scoreThree
                + ", scoreFour=" + scoreFour + ", scoreFive=" + scoreFive + ", scoreSix=" + scoreSix + ", scoreSeven="
                + scoreSeven + ", scoreEight=" + scoreEight + ", scoreNine=" + scoreNine + ", scoreTen=" + scoreTen
                + ", totalCount=" + totalCount + ", satisfactionResult=" + satisfactionResult + "]";
    }


}

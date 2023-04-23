package com.penpar.npsproject.dto;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.sql.Timestamp;

import com.penpar.npsproject.domain.JourneyNps;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JourneyNpsDto {

    private Long id;
    private Long customerId;
    private String journeyState;
    private int npsScore;
    private Timestamp createDate;

    public JourneyNpsDto() {}

    public JourneyNpsDto(Long id, Long customerId, String journeyState, int npsScore, Timestamp createDate) {
        this.id = id;
        this.customerId = customerId;
        this.journeyState = journeyState;
        this.npsScore = npsScore;
        this.createDate = createDate;
    }

    public JourneyNpsDto(JourneyNps source) {
        copyProperties(source, this);
    }

    @Override
    public String toString() {
        return "JourneyNpsDto [id=" + id + ", customerId=" + customerId + ", journeyState=" + journeyState
                + ", npsScore=" + npsScore + ", createDate=" + createDate + "]";
    }

    
}

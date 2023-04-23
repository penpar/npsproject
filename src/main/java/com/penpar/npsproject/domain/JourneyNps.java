package com.penpar.npsproject.domain;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.penpar.npsproject.dto.JourneyNpsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JourneyNps {

    private Long id;
    private Long customerId;
    private String journeyState;
    private int npsScore;
    private Timestamp createDate;

    public JourneyNps() {}

    public JourneyNps(Long id, Long customerId, String journeyState, int npsScore ) {
        this.id = id;
        this.customerId = customerId;
        this.journeyState = journeyState;
        this.npsScore = npsScore;
    }

    public JourneyNps(JourneyNpsDto source) {
        copyProperties(source, this);
    }

    @Override
    public String toString() {
        return "JourneyNps [id=" + id + ", customerId=" + customerId + ", journeyState=" + journeyState + ", npsScore="
                + npsScore + ", createDate=" + createDate + "]";
    }

    
    
}

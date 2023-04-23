package com.penpar.npsproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.penpar.npsproject.domain.JourneyNps;

public class JourneyNpsRowMapper implements RowMapper<JourneyNps> {

    @Override
    public JourneyNps mapRow(ResultSet rs, int rowNum) throws SQLException {
        JourneyNps journeyNps = new JourneyNps();
        journeyNps.setId(rs.getLong("id"));
        journeyNps.setCustomerId(rs.getLong("customer_id"));
        journeyNps.setJourneyState(rs.getString("journey_state"));
        journeyNps.setNpsScore(rs.getInt("nps_score"));
        journeyNps.setCreateDate(rs.getTimestamp("create_date"));
        return journeyNps;
    }

}
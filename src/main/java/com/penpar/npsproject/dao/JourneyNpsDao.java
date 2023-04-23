package com.penpar.npsproject.dao;

import com.penpar.npsproject.domain.JourneyNps;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;

@Repository
public class JourneyNpsDao {
    private final JdbcTemplate jdbcTemplate;

    public JourneyNpsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<JourneyNps> findAll() {
        return jdbcTemplate.query("SELECT * FROM journey_nps", new JourneyNpsRowMapper());
    }


    public Optional<JourneyNps> findbyId (Long id) {
        List<JourneyNps> results = jdbcTemplate.query("SELECT * FROM journey_nps WHERE customer_id = ?", new JourneyNpsRowMapper(), id);
        return ofNullable(results.isEmpty() ? null : results.get(0));
      
    }

    public void save(JourneyNps journeyNps) {
        jdbcTemplate.update(
                "INSERT INTO journey_nps (customer_id, journey_state, nps_score) VALUES (?, ?, ?)",
                journeyNps.getCustomerId(), journeyNps.getJourneyState(), journeyNps.getNpsScore()
        );
    }

}
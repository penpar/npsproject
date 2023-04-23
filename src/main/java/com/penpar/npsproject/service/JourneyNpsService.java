package com.penpar.npsproject.service;

import java.util.List;
import java.util.Optional;

import com.penpar.npsproject.domain.JourneyNps;
import com.penpar.npsproject.dto.NpsResultDto;

public interface JourneyNpsService {

    List<JourneyNps> getAllJourneyNps();
    
    Optional<JourneyNps> getJourneyNpsById(Long id);
    
    void addJourneyNps(JourneyNps journeyNps);
    
    void updateJourneyNps(Long id, JourneyNps journeyNps);
    
    void deleteJourneyNps(Long id);

    NpsResultDto calculateNps();
    
}

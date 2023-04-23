package com.penpar.npsproject.controller;

import java.util.List;
import java.util.stream.Collectors;
import static com.penpar.npsproject.utils.ApiUtils.success;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import com.penpar.npsproject.domain.JourneyNps;
import com.penpar.npsproject.dto.JourneyNpsDto;
import com.penpar.npsproject.dto.NpsResultDto;
import com.penpar.npsproject.service.JourneyNpsService;
import com.penpar.npsproject.utils.CreateTestData;
import com.penpar.npsproject.utils.ApiUtils.ApiResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/journey-nps")
public class JourneyNpsController {
    private final JourneyNpsService journeyNpsService;

    public JourneyNpsController(JourneyNpsService journeyNpsService) {
        this.journeyNpsService = journeyNpsService;
    }

    @Autowired
    CreateTestData createTestData;
    
    @GetMapping
    public ApiResult<List<JourneyNpsDto>> getAllJourneyNps() {
        return success(journeyNpsService.getAllJourneyNps().stream()
                .map(JourneyNpsDto::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ApiResult<JourneyNpsDto> getJourneyNpsById(@PathVariable Long id) {
        return success(journeyNpsService.getJourneyNpsById(id)
                .map(JourneyNpsDto::new)
                .orElseThrow(() -> new NotFoundException("Could not found journey nps for " + id)));
    }

    @PostMapping
    public void addJourneyNps(@RequestBody JourneyNpsDto journeyNpsDto) {
        journeyNpsService.addJourneyNps(new JourneyNps(journeyNpsDto));
    }

    @PutMapping("/{id}")
    public void updateJourneyNps(@PathVariable Long id, @RequestBody JourneyNpsDto journeyNpsDto) {
        //journeyNpsService.updateJourneyNps(id, new JourneyNps(journeyNpsDto));
    }

    @DeleteMapping("/{id}")
    public void deleteJourneyNps(@PathVariable Long id) {
        //journeyNpsService.deleteJourneyNps(id);
    }

    @GetMapping("/test")
    public void getTest() {
        createTestData.createData();
    }

    
    @GetMapping("/result")
    public ApiResult<NpsResultDto> calculateNps() {
        NpsResultDto npsResultDto = journeyNpsService.calculateNps();
        log.info("NPS Result:\n{}", npsResultDto);
        return success(npsResultDto);
    }
        
}
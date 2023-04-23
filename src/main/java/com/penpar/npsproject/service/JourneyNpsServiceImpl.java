package com.penpar.npsproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.penpar.npsproject.dao.JourneyNpsDao;
import com.penpar.npsproject.domain.JourneyNps;
import com.penpar.npsproject.dto.NpsResultDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JourneyNpsServiceImpl implements JourneyNpsService{

    private final JourneyNpsDao journeyNpsDao;

    public JourneyNpsServiceImpl(JourneyNpsDao journeyNpsDao) {
        this.journeyNpsDao = journeyNpsDao;
    }
    
    @Override
    public List<JourneyNps> getAllJourneyNps() {
        return journeyNpsDao.findAll();
    }

    @Override
    public Optional<JourneyNps> getJourneyNpsById(Long id) {
        return journeyNpsDao.findbyId(id);
    }

    @Override
    public void addJourneyNps(JourneyNps journeyNps) {
        journeyNpsDao.save(journeyNps);
    }

    @Override
    public void updateJourneyNps(Long id, JourneyNps journeyNps) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateJourneyNps'");
    }

    @Override
    public void deleteJourneyNps(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteJourneyNps'");
    }

    @Override
    public NpsResultDto calculateNps() {
        List<JourneyNps> npsList = journeyNpsDao.findAll();

        int detractorCount = 0;
        int passiveCount = 0;
        int promoterCount = 0;

        for (JourneyNps nps : npsList) {
            int score = nps.getNpsScore();

            if (score >= 0 && score <= 6) {
                detractorCount++;
            } else if (score >= 7 && score <= 8) {
                passiveCount++;
            } else if (score >= 9 && score <= 10) {
                promoterCount++;
            }
        }

        int totalCount = detractorCount + passiveCount + promoterCount;
        //log.info("###### resultDto : {}" , resultDto);
        log.info(detractorCount + " " + passiveCount + " "+ promoterCount + " " + npsList.size());
        NpsResultDto resultDto = new NpsResultDto();
        resultDto.setScoreOne(getScoreByNumber(npsList, 1));
        resultDto.setScoreTwo(getScoreByNumber(npsList,2));
        resultDto.setScoreThree(getScoreByNumber(npsList, 3));
        resultDto.setScoreFour(getScoreByNumber(npsList, 4));
        resultDto.setScoreFive(getScoreByNumber(npsList, 5));
        resultDto.setScoreSix(getScoreByNumber(npsList, 6));
        resultDto.setScoreSeven(getScoreByNumber(npsList, 7));
        resultDto.setScoreEight(getScoreByNumber(npsList, 8));
        resultDto.setScoreNine(getScoreByNumber(npsList, 9));
        resultDto.setScoreTen(getScoreByNumber(npsList, 10));
        resultDto.setTotalCount(totalCount);


        log.info("###### resultDto : {}" , resultDto);
        if (totalCount == 0) {
            resultDto.setSatisfactionResult(0);
        } else {

            double promoterPercent = (double) promoterCount / totalCount;
            double detractorPercent = (double) detractorCount / totalCount;
            resultDto.setSatisfactionResult((promoterPercent - detractorPercent) * 100);
        }

        return resultDto;
    }

    private int getScoreByNumber(List<JourneyNps> npsList, int number) {
        return (int) npsList.stream()
                .filter(nps -> nps.getNpsScore() == number)
                .count();
    }
    

}

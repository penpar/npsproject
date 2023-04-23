package com.penpar.npsproject.utils;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.penpar.npsproject.dao.CustomerDao;
import com.penpar.npsproject.dao.JourneyNpsDao;
import com.penpar.npsproject.domain.Customer;
import com.penpar.npsproject.domain.JourneyNps;

@Service
public class CreateTestData {

    private final JourneyNpsDao journeyNpsDao;
    private final CustomerDao customerDao;

    public CreateTestData(JourneyNpsDao journeyNpsDao, CustomerDao customerDao) {
        this.journeyNpsDao = journeyNpsDao;
        this.customerDao = customerDao;
    }

    public int createData(){
        
        Random rand = new Random();
       
        for (int i = 1; i < 1000; i++) {
            int grade = rand.nextInt(5) + 1;
            int age = (int) (Math.random() * 56) + 15;
            int gender = rand.nextInt(2) + 1;
            String genderString = "남";
            
            if(gender == 1){
               genderString ="남";
            } else {
                genderString ="여";
            }

            int region = rand.nextInt(6) + 1;
            String regionString = "서울";
            if(region == 1){
                 regionString ="서울";
             } else if(region == 2){
                  regionString ="강원도";
             } else if(region == 3){
                 regionString ="부산";
            }
            else if( region== 4){
                 regionString ="인천";
            }
            else if(region == 5){
                 regionString ="경기";
            }
            else if(region == 6){
                regionString ="서울";
            }

            Customer customer = new Customer(null, "John"+i, Integer.toString(grade), genderString,  age, regionString, "john.doe@example.com");
            customerDao.save(customer);

            int score = rand.nextInt(15) + 1;
            if( score > 10){
                score = 9;
            }

            int state = rand.nextInt(6) + 1;
            String stateString = "활동";
            if(state == 1){
                stateString = "신규";
            } else if (state == 2){
                stateString = "해지";
            } else if (state == 3){
                stateString = "일시정지";
            }
            int asd = 38+i;
            long id = Long.parseLong(Integer.toString(asd));

            JourneyNps journeyNps = new JourneyNps(null, id, stateString, score);
            journeyNpsDao.save(journeyNps);
            //journeyNpsDao.sava(new JourneyNps(null));  
        }

        return 1;
    }



}

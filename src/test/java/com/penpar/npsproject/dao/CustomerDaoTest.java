package com.penpar.npsproject.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.penpar.npsproject.domain.Customer;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerDaoTest {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

  @Test
    public void testSave() {
        for (int i = 0; i < 10; i++) {
            Customer customer1 = new Customer(null, "John"+i, "1", "남",  20+i, "서울", "john.doe@example.com");
            Customer customer2 = new Customer(null, "Test"+i, "1", "여",  30+i, "경기", "john.doe@example.com");
            Customer customer3 = new Customer(null, "Jack"+i, "1", "여",  25, "인천", "john.doe@example.com");
            Customer customer4 = new Customer(null, "MESSI"+i, "1", "남",  43, "부산", "MESSI.doe@example.com");
            Customer customer5 = new Customer(null, "ROONY"+i, "1", "남",  51, "서울", "ROONY.doe@example.com");
            Customer customer6 = new Customer(null, "Test"+i, "1", "여",  37, "경기", "john.doe@example.com");
            Customer customer7 = new Customer(null, "AAAA"+i, "1", "남",  35, "경기", "john.doe@example.com");
        }

        Customer customer = new Customer(null, "John", "1", "male",  30, "서울", "john.doe@example.com");
        
            jdbcTemplate.update("INSERT INTO customer (name, grade , gender, age, region, email) VALUES (?, ?, ?, ?, ?, ?)",
            customer.getName(), customer.getGrade(), customer.getGender(), customer.getAge(), customer.getRegion(), customer.getEmail());



    }

}


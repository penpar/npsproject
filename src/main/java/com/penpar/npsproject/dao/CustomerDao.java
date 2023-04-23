package com.penpar.npsproject.dao;

import java.util.List;
import java.util.Optional;
import static java.util.Optional.ofNullable;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.penpar.npsproject.domain.Customer;

@Repository
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() { // 전체 고객 정보를 DB에서 조회하고, 고객 객체 리스트로 변환
        return jdbcTemplate.query("SELECT * FROM customer", new CustomerRowMapper());
    }

    public Optional<Customer> findById(Long id) { // 고객 정보를 DB에서 조회하고, 조회 결과가 없을 경우 빈 Optional 객체를 반환
        List<Customer> results = jdbcTemplate.query("SELECT * FROM customer WHERE id = ?", new CustomerRowMapper(), id);
        return ofNullable(results.isEmpty() ? null : results.get(0));
    }
    
    public int save(Customer customer) { // 고객 객체를 DB에 추가
        return jdbcTemplate.update("INSERT INTO customer (name, grade, gender, age, region, email) VALUES (?, ?, ?, ?, ?, ?)",
        customer.getName(), customer.getGrade() ,customer.getGender(), customer.getAge(), customer.getRegion(), customer.getEmail());
    }

    public int update(Customer customer) { //고객 객체의 정보를 DB에서 수정
        return jdbcTemplate.update("UPDATE customer SET name = ?, gender = ?, age = ?, region = ?, email = ? WHERE id = ?",
                customer.getName(), customer.getGender(), customer.getAge(), customer.getRegion(), customer.getEmail(), customer.getId());
    }

    public int deleteById(int id) { //고객 정보를 DB에서 삭제
        return jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
    }

    public int findCustomerCount() { // 총고객수 구하기
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customer", Integer.class);
        return count != null ? count : 0;
    }
}
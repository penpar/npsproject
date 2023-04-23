package com.penpar.npsproject.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.penpar.npsproject.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getLong("id"));
        customer.setName(rs.getString("name"));
        customer.setGender(rs.getString("gender"));
        customer.setGrade(rs.getString("grade"));
        customer.setAge(rs.getInt("age"));
        customer.setRegion(rs.getString("region"));
        customer.setEmail(rs.getString("email"));
        // customer.setCreated(rs.getTimestamp("created"));
        // customer.setName(rs.getString("nps_yn"));
        return customer;
    }
}
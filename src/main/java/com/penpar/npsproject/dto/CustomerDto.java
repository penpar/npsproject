package com.penpar.npsproject.dto;

import lombok.Getter;
import lombok.Setter;


import static org.springframework.beans.BeanUtils.copyProperties;

import com.penpar.npsproject.domain.Customer;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String name;
    private String grade;
    private String gender;
    private int age;
    private String region;
    private String email;

    public CustomerDto() {}

    public CustomerDto(Customer source) {
        copyProperties(source, this);
    }

    public CustomerDto(Long id, String name, String grade, String gender, int age, String region, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.age = age;
        this.region = region;
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerDto [id=" + id + ", name=" + name + ", grade=" + grade + ", gender=" + gender + ", age=" + age
                + ", region=" + region + ", email=" + email + "]";
    }

    
}

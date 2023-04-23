package com.penpar.npsproject.domain;

import static org.springframework.beans.BeanUtils.copyProperties;

import com.penpar.npsproject.dto.CustomerDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private Long id;
    private String name;
    private String grade;
    private String gender;
    private int age;
    private String region;
    private String email;

    public Customer() {}

    public Customer(Long id, String name, String grade, String gender, int age, String region, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.age = age;
        this.region = region;
        this.email = email;
    }

    public Customer(CustomerDto source) {
        copyProperties(source, this);
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", grade=" + grade + ", gender=" + gender + ", age=" + age
                + ", region=" + region + ", email=" + email + "]";
    }


}

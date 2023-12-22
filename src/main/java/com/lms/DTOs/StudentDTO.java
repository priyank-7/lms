package com.lms.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
public class StudentDTO {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private Date dob;
    private Date enrollment_date;
    private String image_url;
}

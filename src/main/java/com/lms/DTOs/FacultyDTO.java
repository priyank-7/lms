package com.lms.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class FacultyDTO {

    private String Id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dob;
    private Date joining_date;
    private String gender;
    private String qualification;
    private String image_url;
}

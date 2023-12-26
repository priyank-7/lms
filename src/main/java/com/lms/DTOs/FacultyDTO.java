package com.lms.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Builder
@Getter
@Setter
public class FacultyDTO {

    @Null
    private String Id;
    @NotBlank(message = "Faculty name cannot be blank")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Phone number cannot be blank")
    @Length(min = 10, max = 10, message = "Phone number should be of 10 digits")
    private String phone;
    @NotBlank(message = "Address cannot be blank")
    @Size(max = 200, message = "Address should be less than 200 characters")
    private String address;
    private Date dob;
    private Date joining_date;
    @NotBlank
    private String gender;
    @NotBlank
    private String qualification;
    private String image_url;
}

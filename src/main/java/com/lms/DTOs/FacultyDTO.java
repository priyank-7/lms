package com.lms.DTOs;

import com.lms.Entities.Branch;
import com.lms.Entities.Course;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class FacultyDTO {

    private String faculty_id;
    @NotBlank(message = "Faculty name cannot be blank")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Phone number cannot be blank")
    @Length(min = 10, max = 10, message = "Phone number should be of 10 digits")
    private String phone;
    @Size(min = 8, max = 16)
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Address cannot be blank")
    @Size(max = 200, message = "Address should be less than 200 characters")
    private String address;
    @NotNull(message = "Date of birth cannot be null")
    private Date dob;
    @NotNull(message = "Joining date cannot be null")
    private Date joining_date;
    @NotBlank(message = "Branch cannot be blank")
    private Branch branch;
    @NotBlank(message = "Faculty Gender cannot be blank")
    private String gender;
    @NotBlank(message = "Qualification cannot be blank")
    private String qualification;
    @Null(message = "Image URL should be null")
    private String image_url;
    private List<CourseDTO> courseList;
}

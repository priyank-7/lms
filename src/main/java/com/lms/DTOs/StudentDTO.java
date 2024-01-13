package com.lms.DTOs;

import com.lms.Entities.Branch;
import com.lms.Entities.Student_Course;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class StudentDTO {

    private String student_id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;
    @Size(min = 8, max = 16)
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Phone cannot be blank")
    @Length(min = 10,max = 10,message = "Phone number should be 10 digits")
    private String phone;
    @NotBlank(message = "Address cannot be blank")
    private String address;
    @NotBlank
    private String gender;
    @NotNull(message = "Date of birth cannot be blank")
    private Date dob;
    @NotNull(message = "Branch cannot be blank")
    private Branch branch;
    @NotNull(message = "Enrollment date cannot be blank")
    private Date enrollment_date;
    private List<CourseDTO> courses;
    private String image_url;

}

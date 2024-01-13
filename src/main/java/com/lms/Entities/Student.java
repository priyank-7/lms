package com.lms.Entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Student {

    @Id
    private String student_id;
    @NotBlank
    private String name;
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    @Size(min = 10,max = 10,message = "Phone number should be 10 digits")
    private String phone;
    @NotBlank
    private String address;
    private String gender;
    private Date dob;
    @OneToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    private Date enrollment_date;
    private String image_url;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student_Course> studentCourses;
}

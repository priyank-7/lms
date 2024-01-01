package com.lms.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student {

    @Id
    private String student_id;
    @NotBlank
    private String name;
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
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
    @OneToMany(mappedBy = "student_course_pk.student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student_Course> studentCourses;
}

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
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String address;
    private String gender;
    private Date dob;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore(value = false)
    private Branch branch;
    private Date enrollment_date;
    private String image_url;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "student_course_pk.student")
    @JsonIgnore(value = false)
    private List<Student_Course> studentCourses;
}

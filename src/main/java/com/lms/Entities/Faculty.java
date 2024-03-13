package com.lms.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Faculty {

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private Date dob;
    @OneToOne
    private Branch branch;
    private Date joining_date;
    private String qualification;
    private String image_url;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Course> courseList;
}

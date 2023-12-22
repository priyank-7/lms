package com.lms.Entities;

import jakarta.persistence.*;
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
    private String Id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Date dob;
    private Date joining_date;
    @ManyToOne
    private Branch branch;
    private String gender;
    private String qualification;
    private String image_url;
    @ManyToMany
    private List<Roles> role;
    @ManyToMany
    private List<Course> courseList;
}

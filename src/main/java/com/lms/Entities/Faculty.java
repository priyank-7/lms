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
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Date dob;
    private Date joining_date;
    @OneToOne
    private Branch branch;
    private String gender;
    private String qualification;
    private String image_url;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Roles> role;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Course> courseList;
}

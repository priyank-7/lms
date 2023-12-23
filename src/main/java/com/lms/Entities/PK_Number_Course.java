package com.lms.Entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PK_Number_Course implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer X_number;
    @ManyToOne
    private Course course;
}

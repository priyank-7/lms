package com.lms.Entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PK_Number_Course implements Serializable {

    private Integer X_number;
    @ManyToOne
    private Course course;
}

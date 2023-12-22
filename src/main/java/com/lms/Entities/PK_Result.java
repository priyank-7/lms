package com.lms.Entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PK_Result implements Serializable {

    @OneToOne
    private Course course;
    @ManyToOne
    private Student student;

}

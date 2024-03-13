package com.lms.Entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PK_Result implements Serializable {

    @OneToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private Course course;
    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    private Student student;

}

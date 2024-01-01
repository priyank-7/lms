package com.lms.Entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quiz {

    @Id
    private String quiz_id;
    @ManyToOne
    private Course course;
    private Float total_marks;
    private Float total_time;
    private Date start_time;
    private Boolean is_active;


}

package com.lms.Entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quiz {

    @EmbeddedId
    private PK_Number_Course quiz_id;
    private Float total_marks;
    private Float total_time;
    private Date start_time;
    private Boolean is_active;


}

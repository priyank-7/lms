package com.lms.Entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "AttendedQuestions")
public class AttendedQuestions {

    private Quiz quiz;
    private Student student;
    private AttendedQuestionId attendedQuestionId;
    private Date submittedAt;
    private String answer;
    private Boolean isSubbmitted;
    private Boolean isCorrect;
}

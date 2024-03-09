package com.lms.Repositories;

import com.lms.Entities.Quiz;
import com.lms.Entities.Quiz_Result;
import com.lms.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface QuizResultRepository extends JpaRepository<Quiz_Result, String> {

    List<Quiz_Result> findByStudent(Student student);

    Optional<Quiz_Result> findByStudentAndQuiz(Student student, Quiz quiz);

    List<Quiz_Result> findByQuiz(Quiz quiz);
}

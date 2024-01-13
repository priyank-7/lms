package com.lms.Repositories;

import com.lms.Entities.Course;
import com.lms.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {

    List<Quiz> findByCourse(Course course);
}

package com.lms.Repositories;

import com.lms.Entities.Course;
import com.lms.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, String> {

    List<Quiz> findAllByCourse(Course course);

    @Query("SELECT q FROM Quiz q WHERE q.PostedOn >= ?1 AND q.course = ?2")
    List<Quiz> findAllByPostedOnAfterAndCourse(Date date, Course course);
}

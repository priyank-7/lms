package com.lms.Repositories;

import com.lms.Entities.Course;
import com.lms.Entities.PK_Result;
import com.lms.Entities.Result;
import com.lms.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, PK_Result> {

    @Query("select r from Result r where r.resultId.student = ?1")
    List<Result> findResultByStudent (Student student);

    @Query("select r from Result r where r.resultId.course = ?1")
    List<Result> findResultByCourse (Course course);

    List<Result> findResultByIsPassed(Boolean isPassed);
}

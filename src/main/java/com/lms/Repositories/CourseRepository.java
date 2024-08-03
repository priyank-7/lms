package com.lms.Repositories;

import com.lms.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{
    Optional<Course> findByName(String name);

    List<Course> findByCreditsIsLessThanEqual(Float credits);

    List<Course> findByCreditsIsGreaterThanEqual(Float credits);

    List<Course> findByCreditsEquals(Float credits);

//    @Query("""
//    SELECT count (c) FROM Course c
//    WHERE c.faculties = :facultyId
//    """)
//    Optional<Course> findCourseByFacultiesContaining(String facultyId);
}

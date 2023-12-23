package com.lms.Repositories;

import com.lms.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

    Course getCourseByName(String name);

    Course getCourseByCreditsIsLessThanEqual(Float credits);

    Course getCourseByCreditsIsGreaterThanEqual(Float credits);

    Course getCourseByCreditsEquals(Float credits);
}

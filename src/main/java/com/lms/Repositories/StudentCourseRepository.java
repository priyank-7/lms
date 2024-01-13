package com.lms.Repositories;

import com.lms.Entities.Student_Course;
import com.lms.Entities.Student_Course_PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<Student_Course, Student_Course_PK> {

}

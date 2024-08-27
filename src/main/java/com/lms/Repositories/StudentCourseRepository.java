package com.lms.Repositories;

import com.lms.Entities.Student_Course;
import com.lms.Entities.Student_Course_PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<Student_Course, Student_Course_PK> {

    @Query(nativeQuery = true,
            value="select count(*) > 0 from student_course where student_student_id = :student_id and course_course_id = :courseId")
    Long findStudentByCourseListExists (String student_id, String courseId);
}
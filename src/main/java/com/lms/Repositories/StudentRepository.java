package com.lms.Repositories;

import com.lms.Entities.Student;
import com.lms.Entities.Student_Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Student findStudentByStudentCoursesContaining(Student_Course student_course);
}

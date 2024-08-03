package com.lms.Repositories;

import com.lms.Entities.Branch;
import com.lms.Entities.Course;
import com.lms.Entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, String> {

    List<Faculty> findFacultiesByBranch(Branch branch);

    List<Faculty> findFacultiesByCourseListIsContaining(Course course);

    List<Faculty> findByName(String name);

    @Query(nativeQuery = true,
            value = "select count(*) > 0 from  faculty_course_list where faculties_id =:faculty_id and course_list_course_id =:courseId")
    Long findFacultyByCourseListExists (String faculty_id, String courseId);
}

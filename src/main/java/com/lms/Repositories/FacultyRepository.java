package com.lms.Repositories;

import com.lms.Entities.Branch;
import com.lms.Entities.Course;
import com.lms.Entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, String> {

    List<Faculty> findFacultiesByBranch(Branch branch);

    List<Faculty> findFacultiesByCourseListIsContaining(Course course);

    List<Faculty> findByName(String name);
}

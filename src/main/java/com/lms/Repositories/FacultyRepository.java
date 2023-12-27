package com.lms.Repositories;

import com.lms.Entities.Branch;
import com.lms.Entities.Course;
import com.lms.Entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {

        List<Faculty> findFacultiesByBranch(Branch branch);

        List<Faculty> findFacultiesByCourseListIsContaining(Course course);

        List<Faculty> findByName(String name);
}

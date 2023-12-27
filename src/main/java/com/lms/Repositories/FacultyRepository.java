package com.lms.Repositories;

import com.lms.Entities.Branch;
import com.lms.Entities.Course;
import com.lms.Entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {

        List<Faculty> findFacultiesByBranch(Branch branch);

        List<Faculty> findFacultiesByCourseListIsContaining(Course course);

        Optional<Faculty> findByName(String name);
}

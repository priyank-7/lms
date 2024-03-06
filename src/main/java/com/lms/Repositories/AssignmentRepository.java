package com.lms.Repositories;

import com.lms.Entities.Assignment;
import com.lms.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, String> {

    List<Assignment> findAssignmentByCourse (Course course);

    List<Assignment> findAssignmentsByAssignDateAfterAndCourseAndSubmissionDateBefore(java.util.Date assignDate, Course course, java.util.Date submissionDate);

    List<Assignment> findAssignmentsBySubmissionDateBeforeAndAssignDateAfter(java.util.Date submissionDate, java.util.Date assignDate);

}

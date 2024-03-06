package com.lms.Repositories;

import com.lms.Entities.Assignment;
import com.lms.Entities.Assignment_Result;
import com.lms.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentResultRepository extends JpaRepository<Assignment_Result, String> {

    Optional<Assignment_Result> findByAssignmentAndStudent(Assignment assignment, Student student);

    List<Assignment_Result> findByStudentAndPostedOnAfter(Student student, java.util.Date postedOn);

    Optional<Assignment_Result> findByAssignmentAndStudentAndPostedOnAfter(Assignment assignment, Student student, java.util.Date postedOn);

}

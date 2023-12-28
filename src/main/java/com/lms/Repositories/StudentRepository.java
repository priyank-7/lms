package com.lms.Repositories;

import com.lms.Entities.Branch;
import com.lms.Entities.Course;
import com.lms.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    List<Student> findByName(String name);

    List<Student> findByBranch(Branch branch);

    List<Student> findByCourseListIsContaining(Course course);

}

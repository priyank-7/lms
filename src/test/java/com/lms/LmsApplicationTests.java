package com.lms;

import com.lms.Entities.Assignment;
import com.lms.Entities.Course;
import com.lms.Entities.User;
import com.lms.Repositories.AssignmentRepository;
import com.lms.Repositories.CourseRepository;
import com.lms.Repositories.StudentRepository;
import com.lms.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class LmsApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;
    @Test
    void contextLoads() {

//        "course_id": "ac52cee3-d72c-4add-955e-d18f1c86fa6c",
//                "course_code": "CSE205",
//                "name": "Data Structure and Algorithm",
//                "description": "This course is about Data Structures",
//                "credits": 4.0,
//                "faculties": null


        Course c = Course.builder()
                .course_id("ac52cee3-d72c-4add-955e-d18f1c86fa6c")
                .course_code("CSE205")
                .credits(4.0f)
                .name("Data Structure and Algorithm")
                .description("This course is about Data Structures")
                .build();

        List<Assignment> fvbfjh = this.assignmentRepository.findByCourse(c);

        for (Assignment assignment : fvbfjh) {
            System.out.println(assignment.toString());
        }

    }

    @Test
    void setAssignmentRepository(){

    }


}

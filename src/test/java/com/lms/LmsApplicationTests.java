package com.lms;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Assignment;
import com.lms.Entities.Course;
import com.lms.Entities.Role;
import com.lms.Entities.User;
import com.lms.Helper.DateTime.DateTimeUtilities;
import com.lms.Helper.Roles;
import com.lms.Repositories.*;
import com.lms.Security.Config.CustomUserDetails;
import com.lms.Security.Config.UserDetailServiceImpl;
import com.lms.Services.ServiceImpl.ResultServiceImpl;
import com.lms.Services.ServiceImpl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;

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

    @Autowired
    private ResultServiceImpl resultService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Test
    void contextLoads() {

//        "course_id": "ac52cee3-d72c-4add-955e-d18f1c86fa6c",
//                "course_code": "CSE205",
//                "name": "Data Structure and Algorithm",
//                "description": "This course is about Data Structures",
//                "credits": 4.0,
//                "faculties": null


//        Course c = Course.builder()
//                .course_id("ac52cee3-d72c-4add-955e-d18f1c86fa6c")
//                .course_code("CSE205")
//                .credits(4.0f)
//                .name("Data Structure and Algorithm")
//                .description("This course is about Data Structures")
//                .build();

        //List<Assignment> fvbfjh = this.assignmentRepository.findByCourse(c);

//        for (Assignment assignment : fvbfjh) {
//            System.out.println(assignment.toString());
//        }

    }

    @Test
    void setAssignmentRepository(){

//        System.out.println(resultService.getResultById("5823fa2f-632f-46b1-a585-5c21ad95d9ab", "0a30473b-d875-4d32-a590-785159ecbcba"));
//
//        System.out.println(DateTimeUtilities.firstDayOfYear());


                List<User> user = this.userRepository.findAll();
                for (User user1 : user) {
                    System.out.println(user1.getUser_id());
                    System.out.println(user1.getRoles());
                }
    }

    @Test
    void addStudent(){
        studentService.addStudent(StudentDTO.builder()
                .student_id(UlidCreator.getUlid().toString())
                .email("dksjnk@gmail.com")
                .password("1234")
                .build());
    }

    @Test
    void addRole(){
        roleRepository.save(Role.builder()
                .role_id(UlidCreator.getUlid().toString())
                .name(Roles.ROLE_ADMIN.toString())
                .build());
        roleRepository.save(Role.builder()
                .role_id(UlidCreator.getUlid().toString())
                .name(Roles.ROLE_FACULTY.toString())
                .build());
        roleRepository.save(Role.builder()
                .role_id(UlidCreator.getUlid().toString())
                .name(Roles.ROLE_STUDENT.toString())
                .build());
        roleRepository.save(Role.builder()
                .role_id(UlidCreator.getUlid().toString())
                .name(Roles.ROLE_TEACHING_ASSISTANT.toString())
                .build());
    }


    @Test
    void userdetails_custom_test(){

       CustomUserDetails userDetails = (CustomUserDetails) userDetailService.loadUserByUsername("asd@gmail.com");
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        for(GrantedAuthority role : userDetails.getAuthorities()){
            System.out.println(role.getAuthority());
        }

    }


}

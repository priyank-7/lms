package com.lms;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.*;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.DateTime.DateTimeUtilities;
import com.lms.Helper.ModelMappers.StudentMapper;
import com.lms.Helper.Roles;
import com.lms.Repositories.*;
import com.lms.Security.Config.CustomUserDetails;
import com.lms.Security.Config.UserDetailServiceImpl;
import com.lms.Services.ServiceImpl.ResultServiceImpl;
import com.lms.Services.ServiceImpl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

@SpringBootTest
class LmsApplicationTests {

//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private AssignmentRepository assignmentRepository;
//
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FacultyRepository facultyRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ResultServiceImpl resultService;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
    @Autowired
    private StudentServiceImpl studentService;
//
//    @Autowired
//    private UserDetailServiceImpl userDetailService;

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

//    @Test
//    void setAssignmentRepository(){
//
////        System.out.println(resultService.getResultById("5823fa2f-632f-46b1-a585-5c21ad95d9ab", "0a30473b-d875-4d32-a590-785159ecbcba"));
////
////        System.out.println(DateTimeUtilities.firstDayOfYear());
//
//
//                List<User> user = this.userRepository.findAll();
//                for (User user1 : user) {
//                    System.out.println(user1.getUser_id());
//                    System.out.println(user1.getRoles());
//                }
//    }

    @Test
    void addStudent(){


//        studentService.addStudent(StudentDTO.builder()
//                .student_id(UlidCreator.getUlid().toString())
//                .email("dksjnk@gmail.com")
//                .password("1234")
//                .build());
    }

//    @Test
//    void addRole(){
//        roleRepository.save(Role.builder()
//                .role_id(UlidCreator.getUlid().toString())
//                .name(Roles.ROLE_ADMIN.toString())
//                .build());
//        roleRepository.save(Role.builder()
//                .role_id(UlidCreator.getUlid().toString())
//                .name(Roles.ROLE_FACULTY.toString())
//                .build());
//        roleRepository.save(Role.builder()
//                .role_id(UlidCreator.getUlid().toString())
//                .name(Roles.ROLE_STUDENT.toString())
//                .build());
//        roleRepository.save(Role.builder()
//                .role_id(UlidCreator.getUlid().toString())
//                .name(Roles.ROLE_TEACHING_ASSISTANT.toString())
//                .build());
//    }


//    @Test
//    void userdetails_custom_test(){
//
//       CustomUserDetails userDetails = (CustomUserDetails) userDetailService.loadUserByUsername("asd@gmail.com");
//        System.out.println(userDetails.getUsername());
//        System.out.println(userDetails.getPassword());
//        for(GrantedAuthority role : userDetails.getAuthorities()){
//            System.out.println(role.getAuthority());
//        }
//
//    }


    @Autowired
    private QuizQuestionsRepository quizQuestionsRepository;
    @Test
    void SaveQuizQuestionsTest(){
        QuizQuestions quiz = QuizQuestions.builder()
                .quizId(UlidCreator.getUlid().toString())
                .questions(
                        List.of(
                                QuizQuestion.builder()
                                        .questionId(UlidCreator.getUlid().toString())
                                        .question("What is the capital of India?")
                                        .isMultipleChoice(true)
                                        .options(List.of("Delhi", "Mumbai", "Kolkata", "Chennai"))
                                        .build(),
                                QuizQuestion.builder()
                                        .questionId(UlidCreator.getUlid().toString())
                                        .question("What is the capital of USA?")
                                        .isMultipleChoice(true)
                                        .options(List.of("Washington DC", "New York", "Los Angeles", "Chicago"))
                                        .build(),
                                QuizQuestion.builder()
                                        .questionId(UlidCreator.getUlid().toString())
                                        .question("What is the capital of UK?")
                                        .isMultipleChoice(true)
                                        .options(List.of("London", "Manchester", "Birmingham", "Liverpool"))
                                        .build(),
                                QuizQuestion.builder()
                                        .questionId(UlidCreator.getUlid().toString())
                                        .question("What is the capital of UK?")
                                        .isMultipleChoice(false)
                                        .build()
                        )
                )
                .build();
        quiz = this.quizQuestionsRepository.save(quiz);
        System.out.println(quiz);
    }

    @Test
    void getQuizQuestionsTest(){
        QuizQuestions quiz = this.quizQuestionsRepository.findByQuizId("01J4B91Z458A32GRRMRPEDPST0").orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));
        System.out.println(quiz);
    }

    @Test
    void findCourseByFacultiesContaining(){
        System.out.println(
           this.facultyRepository.findFacultyByCourseListExists("01HSR4EDGGEHQKGWKRKN338DNX","ac52cee3-d72c-4add-955e-d18f1c86fa6")
        );
    }


}

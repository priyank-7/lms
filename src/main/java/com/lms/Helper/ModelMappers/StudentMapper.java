package com.lms.Helper.ModelMappers;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Course;
import com.lms.Entities.Student;
import com.lms.Entities.Student_Course;
import com.lms.Entities.Student_Course_PK;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentMapper {

    public static StudentDTO StudentToStudentDTO(Student student){
        return StudentDTO.builder()
                .student_id(student.getStudent_id())
                .name(student.getName())
                .email(student.getEmail())
                .phone(student.getPhone())
                .address(student.getAddress())
                .gender(student.getGender())
                .dob(student.getDob())
                .enrollment_date(student.getEnrollment_date())
                .branch(student.getBranch())
                .courses(StudentCourseTOCourseList(student.getStudentCourses()))
                .image_url(student.getImage_url())
                .build();
    }

    public static Student StudentDTOToStudent(StudentDTO studentDTO){
        return Student.builder()
                .student_id(studentDTO.getStudent_id())
                .name(studentDTO.getName())
                .email(studentDTO.getEmail())
                .phone(studentDTO.getPhone())
                .address(studentDTO.getAddress())
                .gender(studentDTO.getGender())
                .dob(studentDTO.getDob())
                .enrollment_date(studentDTO.getEnrollment_date())
                .branch(studentDTO.getBranch())
                .image_url(studentDTO.getImage_url())
                .build();
    }

    public static Student StudentDTOToStudent(Student student, StudentDTO studentDTO){
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setPhone(studentDTO.getPhone());
        student.setAddress(studentDTO.getAddress());
        student.setGender(studentDTO.getGender());
        student.setDob(studentDTO.getDob());
        student.setEnrollment_date(studentDTO.getEnrollment_date());
        student.setBranch(studentDTO.getBranch());
        student.setImage_url(studentDTO.getImage_url());
        return student;
    }

    public static Student_Course Student_Course_Creation(Student student, Course course){
        return Student_Course.builder()
                .student_course_pk(Student_Course_PK.builder()
                        .student(student)
                        .course(course)
                        .build())
                .enroll_date(new Date())
                .build();
    }

    public static List<CourseDTO> StudentCourseTOCourseList(List<Student_Course> courseList){
        return Optional.ofNullable(courseList)
                .orElse(Collections.emptyList())
                .stream()
                .map(course -> CourseMapper.CourseToCourseDTO(course.getStudent_course_pk().getCourse()))
                .collect(Collectors.toList());
    }

    public static StudentDTO StudentToStudentDTOResults(Student student) {
        return StudentDTO.builder()
                .student_id(student.getStudent_id())
                .name(student.getName())
                .email(student.getEmail())
                .image_url(student.getImage_url())
                .build();
    }

}

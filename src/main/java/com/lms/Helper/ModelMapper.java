package com.lms.Helper;

import com.lms.DTOs.*;
import com.lms.Entities.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModelMapper {

    public static FacultyDTO FacultyToFacultyDTO(Faculty faculty){
        return FacultyDTO.builder()
                .faculty_id(faculty.getId())
                .name(faculty.getName())
                .email(faculty.getEmail())
                .phone(faculty.getPhone())
                .dob(faculty.getDob())
                .address(faculty.getAddress())
                .branch(faculty.getBranch())
                .joining_date(faculty.getJoining_date())
                .gender(faculty.getGender())
                .qualification(faculty.getQualification())
                .image_url(faculty.getImage_url())
                .courseList(
                        Optional.ofNullable(faculty.getCourseList())
                                .orElse(Collections.emptyList())
                                .stream().map(course -> CourseToCourseDTO(course))
                                .collect(Collectors.toList()))
                .build();
    }

    public static Faculty FacultyDTOTOFaculty(FacultyDTO facultyDTO){
        return Faculty.builder()
                .id(facultyDTO.getFaculty_id())
                .name(facultyDTO.getName())
                .email(facultyDTO.getEmail())
                .phone(facultyDTO.getPhone())
                .dob(facultyDTO.getDob())
                .address(facultyDTO.getAddress())
                .branch(facultyDTO.getBranch())
                .joining_date(facultyDTO.getJoining_date())
                .gender(facultyDTO.getGender())
                .qualification(facultyDTO.getQualification())
                .image_url(facultyDTO.getImage_url())
                .build();
    }

    public static Faculty FacultyDTOTOFaculty(Faculty faculty, FacultyDTO facultyDTO){
        faculty.setName(facultyDTO.getName());
        faculty.setEmail(facultyDTO.getEmail());
        faculty.setPhone(facultyDTO.getPhone());
        faculty.setDob(facultyDTO.getDob());
        faculty.setAddress(facultyDTO.getAddress());
        faculty.setBranch(facultyDTO.getBranch());
        faculty.setJoining_date(facultyDTO.getJoining_date());
        faculty.setGender(facultyDTO.getGender());
        faculty.setQualification(facultyDTO.getQualification());
        faculty.setImage_url(facultyDTO.getImage_url());
        return faculty;
    }

    public static CourseDTO CourseToCourseDTO(Course course){
        return CourseDTO.builder()
                .course_id(course.getCourse_id())
                .course_code(course.getCourse_code())
                .name(course.getName())
                .description(course.getDescription())
                .credits(course.getCredits())
                .build();
    }

    public static Course CourseDTOTOCourse(CourseDTO courseDTO){
        return Course.builder()
                .course_id(courseDTO.getCourse_id())
                .course_code(courseDTO.getCourse_code())
                .name(courseDTO.getName())
                .description(courseDTO.getDescription())
                .credits(courseDTO.getCredits())
                .build();
    }

    public static FacultyDTO CourseFacultyToFacultyDTO(Faculty faculty){
        return FacultyDTO.builder()
                .faculty_id(faculty.getId())
                .name(faculty.getName())
                .email(faculty.getEmail())
                .phone(faculty.getPhone())
                .build();
    }

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
                        .enrollment_date(new Date())
                        .build())
                .build();
    }

    public static List<CourseDTO> StudentCourseTOCourseList(List<Student_Course> courseList){
        return Optional.ofNullable(courseList)
                .orElse(Collections.emptyList())
                .stream()
                .map(course -> CourseToCourseDTO(course.getStudent_course_pk().getCourse()))
                .collect(Collectors.toList());
    }

    public static Student_Course_PK Student_Course_PK_Creation(Student student, Course course){
        return Student_Course_PK.builder()
                .student(student)
                .course(course)
                .build();
    }

    public static AssignmentDTO AssignmentToAssignmentDTO(Assignment assignment){
        return AssignmentDTO.builder()
                .assignment_id(assignment.getAssignment_id())
                .assign_date(assignment.getAssign_date())
                .submission_date(assignment.getSubmission_date())
                .total_marks(assignment.getTotal_marks())
                .build();
    }

    public static Assignment AssignmentDTOTOAssignment(AssignmentDTO assignmentDTO){
        return Assignment.builder()
                .assignment_id(assignmentDTO.getAssignment_id())
                .total_marks(assignmentDTO.getTotal_marks())
                .assign_date(assignmentDTO.getAssign_date())
                .submission_date(assignmentDTO.getSubmission_date())
                .course(CourseDTOTOCourse(assignmentDTO.getCourse()))
                .build();
    }

    public static Assignment AssignmentDTOTOAssignment(Assignment assignment, AssignmentDTO assignmentDTO){
        assignment.setTotal_marks(assignmentDTO.getTotal_marks());
        assignment.setSubmission_date(assignmentDTO.getSubmission_date());
        return assignment;
    }
}

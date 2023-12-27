package com.lms.Helper;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.FacultyDTO;
import com.lms.DTOs.StudentDTO;
import com.lms.Entities.Course;
import com.lms.Entities.Faculty;
import com.lms.Entities.Student;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModelMappers {

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
        faculty.setId(facultyDTO.getFaculty_id());
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
                .id(student.getStudent_id())
                .name(student.getName())
                .email(student.getEmail())
                .phone(student.getPhone())
                .address(student.getAddress())
                .gender(student.getGender())
                .dob(student.getDob())
                .enrollment_date(student.getEnrollment_date())
                .branch(student.getBranch())
                .image_url(student.getImage_url())
                .courseList(
                        Optional.ofNullable(student.getCourseList())
                                .orElse(Collections.emptyList())
                                .stream().map(course -> CourseToCourseDTO(course))
                                .collect(Collectors.toList()))
                .build();
    }

    public static Student StudentDToToStudent(StudentDTO studentDTO){
        return Student.builder()
                .student_id(studentDTO.getId())
                .name(studentDTO.getName())
                .email(studentDTO.getEmail())
                .phone(studentDTO.getPhone())
                .address(studentDTO.getAddress())
                .dob(studentDTO.getDob())
                .gender(studentDTO.getGender())
                .branch(studentDTO.getBranch())
                .enrollment_date(studentDTO.getEnrollment_date())
                .build();
    }

    public static Student StudentDToToStudent(Student student, StudentDTO studentDTO){
        student.setStudent_id(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setPhone(studentDTO.getPhone());
        student.setAddress(studentDTO.getAddress());
        student.setDob(studentDTO.getDob());
        student.setGender(studentDTO.getGender());
        student.setBranch(studentDTO.getBranch());
        student.setEnrollment_date(studentDTO.getEnrollment_date());
        student.setImage_url(studentDTO.getImage_url());
        return student;
    }
}

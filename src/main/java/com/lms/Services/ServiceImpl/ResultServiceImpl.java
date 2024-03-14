package com.lms.Services.ServiceImpl;

import com.lms.DTOs.ResultDTO;
import com.lms.Entities.Result;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMappers.ResultMapper;
import com.lms.Helper.ResultHelper.GradeCheck;
import com.lms.Repositories.CourseRepository;
import com.lms.Repositories.ResultRepository;
import com.lms.Repositories.StudentRepository;
import com.lms.Services.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.resultRepository = resultRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    public ResultDTO saveResult(ResultDTO result, String StudentId, String courseId) {
        result.setGrade(GradeCheck.checkGrade(result.getObtainedMarks()));
        result.setIsPassed(GradeCheck.checkPass(result.getObtainedMarks()));
        result.setPostedOn(new Date());
        return ResultMapper.ResultTOResultDTO(resultRepository.save(
                ResultMapper.ResultDTOToResult(
                        result,
                        studentRepository.findById(StudentId).orElseThrow(() -> new ResourceNotFoundException("Student not found")),
                        courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"))
                )
        ));
    }

    @Override
    public ResultDTO updateResult(ResultDTO result, String studentId, String courseId) {
        result.setGrade(GradeCheck.checkGrade(result.getObtainedMarks()));
        result.setIsPassed(GradeCheck.checkPass(result.getObtainedMarks()));
        result.setPostedOn(new Date());
        Result tempResult = resultRepository.findById(
                ResultMapper.mapToPKResult(
                        studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found")),
                        courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"))
                )
        ).orElseThrow(() -> new ResourceNotFoundException("Result not found"));
        return ResultMapper.ResultTOResultDTO(
                resultRepository.save(ResultMapper.ResultDTOTOResult(tempResult, result)));
    }

    @Override
    @Cacheable("resultById")
    public ResultDTO getResultById(String studentId, String courseId) {
        return ResultMapper.ResultTOResultDTO(resultRepository.findById(
                ResultMapper.mapToPKResult(
                        studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found")),
                        courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"))
                )
        ).orElseThrow(() -> new ResourceNotFoundException("Result not found")));
    }

    @Override
    public void deleteResult(String studentId, String courseId) {
        resultRepository.deleteById(
                ResultMapper.mapToPKResult(
                        studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found")),
                        courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"))
                )
        );
    }

    @Override
    @Cacheable("resultByStudentId")
    public List<ResultDTO> getResultByStudentId(String studentId) {
        return Optional.ofNullable(resultRepository.findResultByStudent(
                studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found"))))
                .orElse(Collections.emptyList())
                .stream().map(ResultMapper::ResultTOResultDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResultDTO> getResultByCourseId(String courseId) {
        return Optional.ofNullable(resultRepository.findResultByCourse(
                courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"))))
                .orElse(Collections.emptyList())
                .stream().map(ResultMapper::ResultTOResultDTO)
                .collect(Collectors.toList());
    }
}

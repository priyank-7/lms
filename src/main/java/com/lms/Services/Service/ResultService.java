package com.lms.Services.Service;

import com.lms.DTOs.ResultDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ResultService {

    ResultDTO saveResult(ResultDTO result, String StudentId, String courseId);

    ResultDTO updateResult(ResultDTO result, String studentId, String courseId);

    ResultDTO getResultById(String studentId, String courseId);

    void deleteResult(String studentId, String courseId);

    List<ResultDTO> getResultByStudentId(String studentId, Authentication authentication);

    List<ResultDTO> getResultByCourseId(String courseId);


}

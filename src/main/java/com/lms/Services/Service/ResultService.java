package com.lms.Services.Service;

import com.lms.DTOs.ResultDTO;

import java.util.List;

public interface ResultService {

    ResultDTO saveResult(ResultDTO result, String StudentId, String courseId);

    ResultDTO updateResult(ResultDTO result, String studentId, String courseId);

    ResultDTO getResultById(String studentId, String courseId);

    void deleteResult(String studentId, String courseId);

    List<ResultDTO> getResultByStudentId(String studentId);

    List<ResultDTO> getResultByCourseId(String courseId);


}

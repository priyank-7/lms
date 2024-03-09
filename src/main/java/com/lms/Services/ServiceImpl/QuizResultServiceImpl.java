package com.lms.Services.ServiceImpl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.DTOs.QuizResultDTO;
import com.lms.Entities.Quiz;
import com.lms.Entities.Quiz_Result;
import com.lms.Entities.Student;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.DateTime.DateTimeUtilities;
import com.lms.Helper.ModelMappers.QuizMapper;
import com.lms.Helper.ModelMappers.QuizResultMapper;
import com.lms.Repositories.QuizRepository;
import com.lms.Repositories.QuizResultRepository;
import com.lms.Repositories.StudentRepository;
import com.lms.Services.Service.QuizResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizResultServiceImpl implements QuizResultService {

    private final QuizResultRepository quizResultRepository;
    private final StudentRepository studentRepository;
    private final QuizRepository quizRepository;

    @Autowired
    public QuizResultServiceImpl(QuizResultRepository quizResultRepository, StudentRepository studentRepository, QuizRepository quizRepository) {
        this.quizResultRepository = quizResultRepository;
        this.studentRepository = studentRepository;
        this.quizRepository = quizRepository;
    }


    @Override
    public List<QuizResultDTO> getQuizResultByStudent(String student_id) {
        return Optional.ofNullable(this.quizResultRepository.findByStudent(
                this.studentRepository.findById(student_id)
                        .orElseThrow(()-> new ResourceNotFoundException("Student not found"))))
                .orElse(Collections.emptyList())
                .stream().map(QuizResultMapper::QuizResultToQuizResultDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuizResultDTO addQuizResult(QuizResultDTO quizResultDTO, String student_id, String quiz_id) {
        quizResultDTO.setQuizResult_id(UlidCreator.getUlid().toString());
        quizResultDTO.setPostedOn(new Date());

        Student tempStudent = this.studentRepository.findById(student_id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"));
        Quiz tempQuiz = this.quizRepository.findById(quiz_id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
        return QuizResultMapper.QuizResultToQuizResultDTO(
                this.quizResultRepository.save(QuizResultMapper.QuizResultDTOTOQuizResult(quizResultDTO, tempStudent, tempQuiz)));
    }

    @Override
    public QuizResultDTO updateQuizResult(QuizResultDTO quizResultDTO, String quizResult_id) {
        Quiz_Result tempQuizResult = this.quizResultRepository.findById(quizResult_id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz Result not found"));
        quizResultDTO.setPostedOn(new Date());
        return QuizResultMapper.QuizResultToQuizResultDTO(
                this.quizResultRepository.save(QuizResultMapper.updateQuizResultFromDTO(tempQuizResult, quizResultDTO)));
    }

    @Override
    public void deleteQuizResult(String quizResult_id) {
        this.quizResultRepository.delete(this.quizResultRepository.findById(quizResult_id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz Result not found")));
    }

    @Override
    public QuizResultDTO getQuizResultByQuizAndStudent(String student_id, String course_id) {
        return QuizResultMapper.QuizResultToQuizResultDTO(this.quizResultRepository.findByStudentAndQuiz(
                this.studentRepository.findById(student_id)
                        .orElseThrow(()-> new ResourceNotFoundException("Student not found")),
                this.quizRepository.findById(course_id)
                        .orElseThrow(()-> new ResourceNotFoundException("Quiz not found")))
                .orElseThrow(()-> new ResourceNotFoundException("Quiz Result not found")));
    }

    @Override
    public List<QuizResultDTO> getQuizResultByQuiz(String quiz_id) {
        return Optional.ofNullable((this.quizResultRepository.findByQuiz(
                this.quizRepository.findById(quiz_id)
                        .orElseThrow(()-> new ResourceNotFoundException("Quiz not found")))))
                .orElse(Collections.emptyList())
                .stream().map(QuizResultMapper::QuizResultToQuizResultDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuizResultDTO getQuizResult(String quizResult_id) {
        return QuizResultMapper.QuizResultToQuizResultDTO(this.quizResultRepository.findById(quizResult_id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz Result not found")));
    }
}

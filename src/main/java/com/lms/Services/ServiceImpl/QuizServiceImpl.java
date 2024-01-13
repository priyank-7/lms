package com.lms.Services.ServiceImpl;

import com.lms.DTOs.CourseDTO;
import com.lms.DTOs.QuizDTO;
import com.lms.Entities.Quiz;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Helper.ModelMapper;
import com.lms.Helper.ModelMappers.QuizMapper;
import com.lms.Repositories.QuizRepository;
import com.lms.Services.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }


    @Override
    public List<QuizDTO> getAllQuizzes() {
        return Optional.of(this.quizRepository.findAll())
                .orElse(Collections.emptyList())
                .stream().map(quiz -> QuizMapper.QuizToQuizDTO(quiz))
                .collect(Collectors.toList());
    }

    @Override
    public QuizDTO getQuizById(String id) {
        return QuizMapper.QuizToQuizDTO(this.quizRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found")));
    }

    @Override
    public QuizDTO addQuiz(QuizDTO quizDTO) {
        quizDTO.setQuiz_id(UUID.randomUUID().toString());
        return QuizMapper.QuizToQuizDTO(this.quizRepository.save(QuizMapper.QuizDTOToQuiz(quizDTO)));
    }

    @Override
    public QuizDTO updateQuiz(String id, QuizDTO quizDTO) {
        Quiz quiz = this.quizRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
        return QuizMapper.QuizToQuizDTO(this.quizRepository.save(QuizMapper.QuizDTOToQuiz(quizDTO, quiz)));
    }

    @Override
    public void deleteQuiz(String id) {
        this.quizRepository.delete(this.quizRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Quiz not found")));
    }

    @Override
    public List<QuizDTO> getQuizByCourse(CourseDTO course) {
        return Optional.of(this.quizRepository.findByCourse(ModelMapper.CourseDTOTOCourse(course)))
                .orElse(Collections.emptyList())
                .stream().map(quiz -> QuizMapper.QuizToQuizDTO(quiz))
                .collect(Collectors.toList());
    }
}

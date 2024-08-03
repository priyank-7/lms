package com.lms.Repositories;

import com.lms.Entities.QuizQuestions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizQuestionsRepository extends MongoRepository<QuizQuestions, String>{

    Optional<QuizQuestions> findByQuizId(String quizId);
}

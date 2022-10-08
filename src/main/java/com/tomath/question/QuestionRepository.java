package com.tomath.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findQuestionById(Long id);
    Boolean existsQuestionByDescription(String description);
}

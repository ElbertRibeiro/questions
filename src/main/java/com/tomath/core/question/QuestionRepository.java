package com.tomath.core.question;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface QuestionRepository extends MongoRepository<Question, String> {
    Question findQuestionByDescription(String description);
    Question findQuestionById(String id);
}

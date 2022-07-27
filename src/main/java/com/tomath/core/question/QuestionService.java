package com.tomath.core.question;

import com.tomath.core.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class QuestionService {

    @Autowired QuestionRepository questionRepository;

    public List<Question> getQuestionList() {
        return questionRepository.findAll();
    }

    public String createQuestion(Question question) {
        if (questionRepository.findQuestionByDescription(question.getDescription()) != null) {
            throw new GenericException("A questão já existe na base de dados");
        }
        return questionRepository.insert(question).getId();
    }

    public void deleteQuestion(String id){
        Question question = questionRepository.findQuestionById(id);
        questionRepository.delete(question);
    }
}

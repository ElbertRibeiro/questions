package com.math.question;

import com.math.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getQuestionList() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) throw new GenericException("Não existem questões cadastradas no banco de dados");
        return questions;
    }

    public Long createQuestion(Question question) {
        if (Boolean.TRUE.equals(questionRepository.existsQuestionByDescription(question.getDescription()))) {
            throw new GenericException("A questão já existe na base de dados");
        }
        return questionRepository.save(question).getId();
    }

    public void deleteQuestion(Long id){
        Question question = questionRepository.findQuestionById(id);
        questionRepository.delete(question);
    }

    public Question getQuestion(long idQuestion){
        return questionRepository.findQuestionById(idQuestion);
    }
}

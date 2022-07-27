package com.tomath.rest.question;

import com.tomath.core.question.Question;
import com.tomath.core.question.QuestionDTO;
import com.tomath.core.question.QuestionService;
import com.tomath.core.utils.ObjectMapperUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/questions") public class QuestionResouces {
    final QuestionService questionService;

    public QuestionResouces(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping public ResponseEntity<List<QuestionDTO>> getQuestionDb() {
        return new ResponseEntity<>(ObjectMapperUtils.mapAll(questionService.getQuestionList(), QuestionDTO.class),
                HttpStatus.OK);
    }

    @PostMapping("/create") public ResponseEntity<String> insertQuestion(@RequestBody QuestionDTO question) {
        return new ResponseEntity<>(questionService.createQuestion(ObjectMapperUtils.map(question, Question.class)),
                HttpStatus.CREATED);
    }
}

package com.math.question;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
public class QuestionController {
    final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getQuestionDb() {
        ModelMapper modelMapper = new ModelMapper();
        return new ResponseEntity<>(questionService.getQuestionList().stream()
                .map(entity -> modelMapper.map(entity, QuestionDTO.class))
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> insertQuestion(@RequestBody QuestionDTO questionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return new ResponseEntity<>(questionService.createQuestion(modelMapper.map(questionDTO, Question.class)),
                HttpStatus.CREATED);
    }

    @GetMapping("/loadQuestion")
    public ResponseEntity<QuestionDTO> getQuestion(@RequestParam("id") long idQuestion) {
        ModelMapper modelMapper = new ModelMapper();
        Question question = questionService.getQuestion(idQuestion);
        return new ResponseEntity<>(modelMapper.map(question, QuestionDTO.class), HttpStatus.OK);
    }
}

package com.tomath.rest;

import com.tomath.dto.QuestionDTO;
import com.tomath.entity.Question;
import com.tomath.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/questions")  public class MathQuestion {
    @Autowired QuestionService questionService;
    @GetMapping("/questions")
    @CrossOrigin(origins = "http://localhost:19006/")
    public ResponseEntity<String> seachQuestion(@Valid @RequestBody QuestionDTO dto){
        Question question = new Question();

        question.setDescription(dto.getDescription());
        question.setId(dto.getMatter());
        question.setNivel(dto.getNivel());
        question.setSubjectMatter(dto.getSubjectMatter());
        question.setRightAnswer(dto.getRightAnswer());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

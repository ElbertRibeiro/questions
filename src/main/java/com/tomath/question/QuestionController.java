package com.tomath.question;

import com.tomath.entity.Matter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private ModelMapper modelMapper;
    @Autowired
    QuestionService questionService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:19006/")
    public ResponseEntity<List<QuestionDTO>> getQuestionDb() {
        return new ResponseEntity<>(questionService.getQuestionList().stream()
                .map(entity -> modelMapper.map(entity, QuestionDTO.class))
                .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> insertQuestion(@RequestBody QuestionDTO questionDTO) {
        Matter matter = new Matter();
        matter.setTitle(questionDTO.getMatter());

        Question question = new Question();
        question.setMatter(matter);
        question.setNivel(questionDTO.getNivel());
        question.setSubjectMatter(questionDTO.getSubjectMatter());
        question.setDescription(questionDTO.getDescription());
        question.setRightAnswer(questionDTO.getRightAnswer());

        return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping("/loadQuestion")
    public ResponseEntity<QuestionDTO> getQuestion(@RequestParam("id") long idQuestion) {
        Question question = questionService.getQuestion(idQuestion);

        QuestionDTO dto = new QuestionDTO();
        dto.setDescription(question.getDescription());
        dto.setMatter(question.getMatter().getTitle());
        dto.setNivel(question.getNivel());
        dto.setRightAnswer(question.getRightAnswer());
        dto.setSubjectMatter(question.getSubjectMatter());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

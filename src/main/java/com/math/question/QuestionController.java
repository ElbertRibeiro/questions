package com.math.question;

import com.math.matter.Matter;
import com.math.subject.Subject;
import com.math.subject.SubjectDTO;
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
        Matter matter = new Matter();
        matter.setTitle(questionDTO.getMatter());

        Subject subject = new Subject();
        subject.setSubjectName(questionDTO.getSubject().getSubjectName());

        Question question = new Question();
        question.setMatter(matter);
        question.setNivel(questionDTO.getNivel());
        question.setSubject(subject);
        question.setDescription(questionDTO.getDescription());
        question.setRightAnswer(questionDTO.getRightAnswer());

        return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping("/loadQuestion")
    public ResponseEntity<QuestionDTO> getQuestion(@RequestParam("id") long idQuestion) {
        Question question = questionService.getQuestion(idQuestion);

        QuestionDTO dto = new QuestionDTO();
        SubjectDTO subject = new SubjectDTO();
        subject.setSubjectName(question.getSubject().getSubjectName());
        dto.setDescription(question.getDescription());
        dto.setMatter(question.getMatter().getTitle());
        dto.setNivel(question.getNivel());
        dto.setRightAnswer(question.getRightAnswer());
        dto.setSubject(subject);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

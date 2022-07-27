package com.tomath.question;

import com.tomath.core.question.QuestionDTO;
import com.tomath.core.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) class QuestionResoucesTest {
    @Autowired private TestRestTemplate testRestTemplate;
    @Autowired private QuestionService service;

    @Test void getQuestionDbTest() {
        QuestionDTO dtos = new QuestionDTO();
        dtos.setDescription("Testee");
        dtos.setMatter("teste");
        dtos.setNivel(2);
        dtos.setRightAnswer("10");
        dtos.setSubjectMatter("teste");
        HttpEntity<QuestionDTO> httpEntity = new HttpEntity<>(dtos);
        ResponseEntity<String> response =
                testRestTemplate.exchange("/questions/create", HttpMethod.POST, httpEntity, String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        service.deleteQuestion(response.getBody());
    }
}

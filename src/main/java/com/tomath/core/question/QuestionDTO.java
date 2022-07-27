package com.tomath.core.question;

import lombok.Data;

@Data
public class QuestionDTO {
    private String description;
    private String matter;
    private String subjectMatter;
    private int nivel;
    private String rightAnswer;
}

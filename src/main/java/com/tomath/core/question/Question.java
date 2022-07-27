package com.tomath.core.question;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Question {
    private static final long serialVersionUID = 2L;

    @Id
    private String id;
    private String description;
    private String matter;
    private String subjectMatter;
    private int nivel;
    private String rightAnswer;
}

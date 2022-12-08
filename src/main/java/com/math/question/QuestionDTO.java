package com.math.question;

import com.math.subject.SubjectDTO;
import lombok.Data;

@Data
public class QuestionDTO {
    private String description;
    private String matter;
    private SubjectDTO subject;
    private int nivel;
    private String rightAnswer;
}

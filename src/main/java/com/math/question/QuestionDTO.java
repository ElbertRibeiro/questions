package com.math.question;

import com.math.matter.MatterDTO;
import com.math.subject.SubjectDTO;
import lombok.Data;

@Data
public class QuestionDTO {
    private MatterDTO matter;
    private SubjectDTO subject;
    private String description;
    private String rightAnswer;
    private int nivel;
}

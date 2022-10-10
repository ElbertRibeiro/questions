package com.tomath.question;

import com.tomath.entity.Matter;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Question {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String subjectMatter;
    private int nivel;
    private String rightAnswer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Matter matter;
}

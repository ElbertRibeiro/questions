package com.math.question;

import com.math.matter.Matter;
import com.math.subject.Subject;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = -4307173288909336584L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int nivel;
    private String rightAnswer;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Matter matter;
}

package com.math.subject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Subject implements Serializable {

    private static final long serialVersionUID = 5571782646693563848L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSubject;

    private String subjectName;
}

package com.math.matter;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Matter implements Serializable {

    private static final long serialVersionUID = 4187637590627096046L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long matterId;
    private String title;
}

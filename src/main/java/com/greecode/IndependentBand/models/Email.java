package com.greecode.IndependentBand.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private Boolean sending;
//    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

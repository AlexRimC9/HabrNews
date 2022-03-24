package com.project.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "dialogues")
@Entity
public class Dialogues {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dialogues;

    @Column
    private String NameDialogue;

    @Column
    private int quantityPeople;

    @Column
    private String people;

    @Column
    private int quantityMessage;

    @Column
    private String message;


}

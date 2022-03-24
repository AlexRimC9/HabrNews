package com.project.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Table(name = "message")
@Entity
public class Message {
    @Id
    @Column
    private Long id;

    @Column
    private Long id_user;

    @Column
    private Long id_dialogues;

    @Column
    private String text;

    @Column
    private LocalDateTime date = LocalDateTime.now();
}


package com.project.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notification")

public class Notification {

    @Id
    @Column
    private Long idUser;

    @Column
    private Long idDialogues;

    @Column
    private LocalDateTime date = LocalDateTime.now();
}

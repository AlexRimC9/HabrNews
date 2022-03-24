package com.project.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "oldpassword")
@Entity
@Data
public class OldPassword {

    @Column
    private Long idUser;
    @Id
    @Column(unique = true)
    private String hashpassword;



}

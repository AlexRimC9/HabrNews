package com.project.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "privilege")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPrivilege;

    private String name;



    public Privilege(String name) {
    this.name = name;
    }

    public Privilege(Long id) {
        this.idPrivilege = id;
    }
    public Privilege(Long id, String login) {
        this.idPrivilege = id;
        this.name = login;
    }

    public Privilege() {

    }

}


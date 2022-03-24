package com.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "habrs")
@Entity
public class Habr {



    @Column
    private String writers;
    @Id
    @Column
    private String themes;

    @Column
    private String texts;

    @Column
    private String dates;



    public String getWriter() {
        return writers;
    }

    public void setWriter(String writer) {
        this.writers = writer;
    }
    public String getTheme() {
        return themes;
    }

    public void setTheme(String theme) {
        this.themes = theme;
    }

    public String getText() {
        return texts;
    }

    public void setText(String text) {
        this.texts = text;
    }

    public String getDate() {
        return dates;
    }

    public void setDate(String date) {
        this.dates = date;
    }


    }


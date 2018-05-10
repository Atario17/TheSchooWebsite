package com.kondrat.TheSchooWebsite.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pupil {
    String name;
    int id;

    public Pupil(){
    }

    public Pupil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

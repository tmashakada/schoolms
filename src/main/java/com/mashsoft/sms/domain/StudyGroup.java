package com.mashsoft.sms.domain;

import javax.persistence.*;

@Entity
@Table(name = "CB_STUDY_GROUP")
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public StudyGroup() {
        this("");
    }

    public StudyGroup(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

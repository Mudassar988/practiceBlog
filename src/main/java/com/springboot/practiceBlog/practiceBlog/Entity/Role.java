package com.springboot.practiceBlog.practiceBlog.Entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.GenerationType;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;


@Setter
    @Getter
    @Entity
    @Table(name = "roles")
    public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(length = 60)
        private String name;
    }

package com.springboot.practiceBlog.practiceBlog.Entity;

import javax.persistence.*;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.UniqueConstraint;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "Post", uniqueConstraints = {@UniqueConstraint(columnNames = ("title"))}
)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // this line autogenerates the values of id in database
    private  long id;

    @Column(name = "title", nullable = false)
    private  String title;

    @Column(name = "content", nullable = false)
    private  String content;
}

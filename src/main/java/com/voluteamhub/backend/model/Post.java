package com.voluteamhub.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
// src/main/java/com/example/demo/entity/Post.java

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "association_id", nullable = false)
    private Association author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Association getAuthor() {
        return author;
    }

    public void setAuthor(Association author) {
        this.author = author;
    }
}


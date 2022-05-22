package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {
    @EmbeddedId
    private CommentId id;

    @Column(name = "Text")
    private String text;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @MapsId("authorID")
    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private Employee employee;

}
package com.polytech.kursova.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @MapsId("authorID")
    @ManyToOne
    @JoinColumn(name = "AuthorID")
    private Employee employee;

}
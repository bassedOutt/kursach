package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CommentId implements Serializable {
    private static final long serialVersionUID = -2828787477258294323L;
    @Column(name = "CommentID", nullable = false)
    private Integer commentID;
    @Column(name = "AuthorID", nullable = false)
    private Integer authorID;
    @Column(name = "CaseID", nullable = false)
    private Integer caseID;
    @Column(name = "CustomerID", nullable = false)
    private Integer customerID;

    @Override
    public int hashCode() {
        return Objects.hash(caseID, customerID, commentID, authorID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommentId entity = (CommentId) o;
        return Objects.equals(this.caseID, entity.caseID) &&
                Objects.equals(this.customerID, entity.customerID) &&
                Objects.equals(this.commentID, entity.commentID) &&
                Objects.equals(this.authorID, entity.authorID);
    }
}
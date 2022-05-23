package com.polytech.kursova.repository;

import com.polytech.kursova.entity.Comment;
import com.polytech.kursova.entity.CommentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, CommentId> {
    List<Comment> findCommentsById_CaseID(Integer caseId);
}

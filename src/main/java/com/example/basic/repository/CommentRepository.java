package com.example.basic.repository;

import com.example.basic.entity.Comment;
import com.example.basic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

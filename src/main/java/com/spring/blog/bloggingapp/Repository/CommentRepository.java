package com.spring.blog.bloggingapp.Repository;

import com.spring.blog.bloggingapp.Entity.BlogPostEntity;
import com.spring.blog.bloggingapp.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    List<CommentEntity> findByPostId(Integer postId);
}

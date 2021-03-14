package com.spring.blog.bloggingapp.Repository;

import com.spring.blog.bloggingapp.Entity.BlogPostEntity;
import com.spring.blog.bloggingapp.Request.BlogPostRequest;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPostEntity, Integer> {

    @Query(value = "select bp from BlogPostEntity bp where (:id is null or bp.id = :id) " +
            "and (:userId is null or bp.userId = :userId)" +
            "and (:title is null or bp.title like %:title%)")
    List<BlogPostEntity> getListPost(Integer id, Integer userId, String title);

}

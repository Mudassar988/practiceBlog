package com.springboot.practiceBlog.practiceBlog.Repository;

import com.springboot.practiceBlog.practiceBlog.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

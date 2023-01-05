package com.springboot.practiceBlog.practiceBlog.Service;

import com.springboot.practiceBlog.practiceBlog.Dto_Payload.PostDto;
import java.util.List;

public interface Post_service {

    //creaate post
    PostDto createPost(PostDto createPostDto);

    // Get  all posts
    List<PostDto> getAllPosts();

}

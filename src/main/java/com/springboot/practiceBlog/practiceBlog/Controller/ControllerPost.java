package com.springboot.practiceBlog.practiceBlog.Controller;

import com.springboot.practiceBlog.practiceBlog.Dto_Payload.PostDto;
import com.springboot.practiceBlog.practiceBlog.Service.Post_service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/api")
public class ControllerPost {

    private Post_service postService;
    public ControllerPost(Post_service postService) {
        this.postService = postService;
    }


    //Create post                       //  http://localhost:8080/api/create
    @PostMapping("api/create")
    public ResponseEntity<PostDto> create(@RequestBody PostDto incomingCreate) {
        return new ResponseEntity<>(postService.createPost(incomingCreate), HttpStatus.CREATED);
    }


    // get all posts rest api           //  http://localhost:8080/api/get

    @GetMapping("api/get")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

}

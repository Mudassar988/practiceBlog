package com.springboot.practiceBlog.practiceBlog.Service;

import com.springboot.practiceBlog.practiceBlog.Dto_Payload.PostDto;
import com.springboot.practiceBlog.practiceBlog.Entity.Post;
import com.springboot.practiceBlog.practiceBlog.Repository.PostRepository;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Post_service_Impl implements  Post_service {

    private PostRepository postRepository;

    public Post_service_Impl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    //Creating post
    @Override
    public PostDto createPost(PostDto createPostDto) {
        Post createPost = DtoToEntity(createPostDto);          // converting incoming postDto type argument to post entity type
        Post savePost = postRepository.save(createPost);    // saving post type entity in database through postrepository
        PostDto returnPost = EntityToDto(savePost);         // converting saved post to dto type and returning it to client
        return returnPost;
    }


    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> EntityToDto(post)).collect(Collectors.toList());
    }



    public Post DtoToEntity(PostDto DtoToEntity_Arg) {      // converting Dto type incominng client request to post entity type
        Post post = new Post();
        post.setId(DtoToEntity_Arg.getId());
        post.setTitle(DtoToEntity_Arg.getTitle());
        post.setContent(DtoToEntity_Arg.getContent());
        return  post;
    }
    public  PostDto EntityToDto(Post EntityToDto_Arg) {     // converting post type bacck to dto type
        PostDto postDto = new PostDto();
        postDto.setId(EntityToDto_Arg.getId());
        postDto.setTitle(EntityToDto_Arg.getTitle());
        postDto.setContent(EntityToDto_Arg.getContent());
        return  postDto;
    }
}

package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entities.Post;
import com.example.demo.requests.PostCreateRequest;
import com.example.demo.services.PostService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    //@RequestParam : bize gelen rquestin parametreleri sağında olan değilkenin içine at
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.getAllPosts(userId);
    }


    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePost(newPostRequest);
    }

    @GetMapping("/{posId}")
    public Post getOnePost(@PathVariable long postId){
        return postService.getOnePostById(postId);
    }

}

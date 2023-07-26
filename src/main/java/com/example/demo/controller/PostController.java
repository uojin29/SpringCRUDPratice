package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.dto.request.PostInsertRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import com.example.demo.dto.response.PostResponse;
import com.example.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<PostResponse> insert(@RequestBody PostInsertRequest request){
        return ResponseEntity.ok(postService.insert(request));
    }

    @PostMapping("/post/{post_id}")
    public ResponseEntity<Post> findById(@PathVariable Long post_id){
        return ResponseEntity.ok(postService.findById(post_id));
    }
    @PostMapping("/post/list")
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @PatchMapping("/post/{post_id}")
    public ResponseEntity<Post> update(@PathVariable Long post_id, @RequestBody PostUpdateRequest request){
        return ResponseEntity.ok(postService.update(post_id, request));
    }

    @DeleteMapping("/post/{post_id}")
    public ResponseEntity<Long> delete(@PathVariable Long post_id){
        postService.delete(post_id);
        return ResponseEntity.ok(post_id);
    }
}

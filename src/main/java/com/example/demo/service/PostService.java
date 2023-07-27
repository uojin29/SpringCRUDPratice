package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.dto.request.PostInsertRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import com.example.demo.dto.response.PostResponse;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public Long insert(Post post){
//        Post post = Post.builder()
//                .post_name(request.getPost_name())
//                .price(request.getPrice())
//                .build();
        Post p = postRepository.save(post);

        return p.getPost_id();
//        return PostResponse.builder()
//                .post_id(post.getPost_id())
//                .post_name(post.getPost_name())
//                .price(post.getPrice())
//                .build();
    }

    public Post findById(Long post_id){
        Post post = postRepository.findById(post_id).get();
        return post;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post update(Long post_id, PostUpdateRequest request){
        Post post = postRepository.findById(post_id).get();
        post.update(request);
        postRepository.save(post);
        return post;
    }

    public void delete(Long post_id){
        postRepository.deleteById(post_id);
    }

}

package com.example.demo.domain;

import com.example.demo.dto.request.PostInsertRequest;
import com.example.demo.dto.request.PostUpdateRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long post_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Member member;
    private String post_name;
    private int price;

    public static Post from(Member member, PostInsertRequest request){
        return Post.builder()
                .post_name(request.getPost_name())
                .price(request.getPrice())
                .member(member)
                .build();
    }
    public void update(PostUpdateRequest request){
        this.post_name = request.getPost_name();
        this.price = request.getPrice();
    }
}

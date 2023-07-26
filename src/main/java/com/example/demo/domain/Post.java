package com.example.demo.domain;

import com.example.demo.dto.request.PostUpdateRequest;
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

    @ManyToOne
    private Member member;
    private String post_name;
    private int price;

    public void update(PostUpdateRequest request){
        this.post_name = request.getPost_name();
        this.price = request.getPrice();
    }
}

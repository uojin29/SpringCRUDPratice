package com.example.demo.dto.request;

import lombok.Data;

@Data
public class PostInsertRequest {
    Long member_id;
    String post_name;
    int price;
}

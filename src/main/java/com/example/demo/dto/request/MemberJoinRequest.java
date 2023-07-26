package com.example.demo.dto.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class MemberJoinRequest {
    String name;
    String email;
}

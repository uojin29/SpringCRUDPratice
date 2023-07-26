package com.example.demo.dto.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class MemberUpdateRequest {
    Long id;
    String name;
    String email;
}

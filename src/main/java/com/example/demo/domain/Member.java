package com.example.demo.domain;

import com.example.demo.dto.request.MemberUpdateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String email;

    public void update(MemberUpdateRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
    }
}

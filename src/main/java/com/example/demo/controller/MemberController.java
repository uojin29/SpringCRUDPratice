package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.dto.request.MemberJoinRequest;
import com.example.demo.dto.request.MemberUpdateRequest;
import com.example.demo.dto.response.*;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/member")
    public ResponseEntity<MemberResponse> join(@RequestBody MemberJoinRequest request){
        return ResponseEntity.ok(memberService.join(request));
    }

    @PostMapping("/member/{id}")
    public ResponseEntity<MemberResponse> showById(@PathVariable Long id){
        return ResponseEntity.ok(memberService.showById(id));
    }

    @PostMapping("/member/list")
    public ResponseEntity<List<MemberResponse>> showList(){
        return ResponseEntity.ok(memberService.showList());
    }

    @PatchMapping("/member/{id}")
    public ResponseEntity<Member> update(@PathVariable Long id, @RequestBody MemberUpdateRequest request){
        return ResponseEntity.ok(memberService.update(id, request));
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<MemberResponse> delete(@PathVariable Long id){
//        MemberResponse deleteMember = memberService.delete(id);
        return ResponseEntity.ok(memberService.delete(id));
    }
}

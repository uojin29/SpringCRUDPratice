package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.request.MemberJoinRequest;
import com.example.demo.dto.request.MemberUpdateRequest;
import com.example.demo.dto.response.*;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository; // DI : dependency injection
    // 회원가입
    public MemberResponse join(MemberJoinRequest request){
        Member member = Member.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .build();

            duplicate(request.getEmail());
            memberRepository.create(member);

            return MemberResponse.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .email(member.getEmail())
                    .build();
    }

    // 중복 검사
    public void duplicate(String email){
        List<Member> memberList = memberRepository.findByEmail(email);
        if(!memberList.isEmpty()){
            throw new IllegalStateException("이미 회원가입된 메일입니다.");
        }
    }

    // 아이디로 검색
    public MemberResponse showById(Long id){
        Member member = memberRepository.findById(id);
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
    public List<MemberResponse> showList(){
        List<Member> memberList = memberRepository.findAll();
        List<MemberResponse> returnList = new ArrayList<>();
        memberList.forEach(member -> {
            MemberResponse memberResponse = new MemberResponse();

            memberResponse.setId(member.getId());
            memberResponse.setName(member.getName());
            memberResponse.setEmail(member.getEmail());

            returnList.add(memberResponse);
        });

        return returnList;
    }
    public Member update(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id);
        duplicate(request.getEmail());
        member.update(request);
        return member;
    }
    public MemberResponse delete(Long id){
        Member member = memberRepository.deleteById(id);
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }

}

package com.person.library_project.member.controller;

import com.person.library_project.member.dto.MemberDto;
import com.person.library_project.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 클라이언트에게 데이터를 보내주기 위해 RestController 로 지정
 * RequestMapping 으로 공통된 URL 을 묶어준다.
 */
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signup(@RequestBody MemberDto memberDto) {
        memberService.signup(memberDto);
        return ResponseEntity
                .ok()
                .body("signup successful");
    }
}

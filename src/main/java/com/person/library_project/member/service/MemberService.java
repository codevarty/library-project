package com.person.library_project.member.service;

import com.person.library_project.member.dto.MemberDto;
import com.person.library_project.member.entity.Member;
import com.person.library_project.member.entity.Role;
import com.person.library_project.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long signup(MemberDto request) {
        memberRepository.findByEmail(request.getEmail())
                .ifPresent(member -> new IllegalArgumentException("already member"));

        Member newMember = Member.builder()
                .email(request.getEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhone())
                .canLoan('Y')
                .role(Role.USER)
                .build();

        memberRepository.save(newMember);

        return newMember.getMid();
    }
}

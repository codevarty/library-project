package com.person.library_project.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDto {
    private final String email;
    private final String password;
    private final String name;
    private final String phone;
}

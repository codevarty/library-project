package com.person.library_project.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Member")
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @Column(name = "m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;

    @Column(length = 30, unique = true, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(name = "phone", columnDefinition = "char(11)", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "can_loan", columnDefinition = "char(1) default 'Y'", nullable = false)
    private char canLoan;

    @CreatedDate // 엔티티가 생성되었을 때 자동으로 생성 날짜를 입력해준다.
    @Temporal(TemporalType.DATE) // java.util.Date 의 경우 날짜와 시간이 모두 들어간다.
    @Column(name = "m_created_at", nullable = false)
    private Date createdAt;
}

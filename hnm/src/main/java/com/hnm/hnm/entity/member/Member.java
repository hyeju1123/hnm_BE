package com.hnm.hnm.entity.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String profile;

    private String snsType;

    private final LocalDateTime createDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String email, String password,
                  String snsType, Authority authority) {
        this.email = email;
        this.password = password;
        this.snsType = snsType;
        this.authority = authority;
    }
}

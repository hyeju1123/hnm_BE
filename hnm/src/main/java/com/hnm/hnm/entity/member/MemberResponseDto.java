package com.hnm.hnm.entity.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long memberId;

    private String email;

    @JsonIgnore
    private String password;

    public MemberResponseDto(Member entity) {
        this.memberId = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
    }

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member);
    }

}

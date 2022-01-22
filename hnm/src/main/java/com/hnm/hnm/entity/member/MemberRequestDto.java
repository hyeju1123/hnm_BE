package com.hnm.hnm.entity.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
public class MemberRequestDto {

    private String email;

    private String password;

    private String oauth;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .snsType(oauth)
                .authority(Authority.FREE_USER)
                .build();
    }

    public Member toMember(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
        return toEntity();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}

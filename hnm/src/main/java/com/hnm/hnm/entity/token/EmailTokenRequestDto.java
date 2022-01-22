package com.hnm.hnm.entity.token;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmailTokenRequestDto {

    private String email;
    private String emailToken;

    @Builder
    public EmailTokenRequestDto(String email, String emailToken) {
        this.email = email;
        this.emailToken = emailToken;
    }
}

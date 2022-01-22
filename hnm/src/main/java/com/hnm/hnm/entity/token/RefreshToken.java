package com.hnm.hnm.entity.token;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class RefreshToken {

    // member id 값이 들어감
    @Id
    @Column(name = "refresh_token_id")
    private String key;

    // refresh token 이 들어감
    private String value;

    private LocalDateTime createDate = LocalDateTime.now();

    private LocalDateTime updateDate = LocalDateTime.now();

    public RefreshToken updateValue(String token) {
        this.value = token;
        this.updateDate = LocalDateTime.now();
        return this;
    }

    @Builder
    public RefreshToken(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

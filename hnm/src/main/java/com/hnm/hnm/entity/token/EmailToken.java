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
public class EmailToken {

    @Id
    @Column(name = "email_token_id")
    private String key;

    private String value;

    private LocalDateTime createDate = LocalDateTime.now();

    private LocalDateTime updateDate = LocalDateTime.now();

    public EmailToken updateValue(String token) {
        this.value = token;
        this.updateDate = LocalDateTime.now();
        return this;
    }

    @Builder
    public EmailToken(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

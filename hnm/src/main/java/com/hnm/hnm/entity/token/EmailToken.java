package com.hnm.hnm.entity.token;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class EmailToken {

    @Id
    @Column(name = "email_token_id")
    private String key;

    private String value;

    public EmailToken updateValue(String token) {
        this.value = token;
        return this;
    }

    @Builder
    public EmailToken(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

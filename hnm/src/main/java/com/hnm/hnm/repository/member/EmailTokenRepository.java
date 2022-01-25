package com.hnm.hnm.repository.member;

import com.hnm.hnm.entity.token.EmailToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailTokenRepository extends JpaRepository<EmailToken, Long> {

    Optional<EmailToken> findByKeyAndValue(String key, String value);

    Optional<EmailToken> findByKey(String key);

    boolean existsByKey(String key);
}

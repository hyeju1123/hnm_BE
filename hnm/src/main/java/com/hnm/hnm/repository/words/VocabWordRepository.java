package com.hnm.hnm.repository.words;

import com.hnm.hnm.entity.words.Vocab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabWordRepository extends JpaRepository<Vocab, Long> {


}

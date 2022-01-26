package com.hnm.hnm.entity.words;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Hsk {

    @Id
    @Column(name = "hsk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    private String meaning;

    private String intonation;

    @Column(name = "class")
    private String wordClass;

    private int level;

    private String theme;

    @Builder
    public Hsk(String word, String meaning,
               String intonation, String wordClass,
               int level, String theme) {
        this.word = word;
        this.meaning = meaning;
        this.intonation = intonation;
        this.wordClass = wordClass;
        this.level = level;
        this.theme = theme;
    }
}

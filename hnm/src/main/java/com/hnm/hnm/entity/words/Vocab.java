package com.hnm.hnm.entity.words;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
public class Vocab {

    @Id
    @Column(name = "vocab_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    private String meaning;

    private String intonation;

    @Column(name = "class")
    private String wordClass;

    private String explanation;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "note_id")
    private Note note;

    @Builder
    public Vocab(String word, String meaning,
               String intonation, String wordClass,
               String explanation, Note note) {
        this.word = word;
        this.meaning = meaning;
        this.intonation = intonation;
        this.wordClass = wordClass;
        this.explanation = explanation;
        this.note = note;
    }
}

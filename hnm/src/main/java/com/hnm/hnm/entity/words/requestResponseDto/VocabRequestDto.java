package com.hnm.hnm.entity.words.requestResponseDto;

import com.hnm.hnm.entity.words.Note;
import com.hnm.hnm.entity.words.Vocab;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VocabRequestDto {

    private String word;

    private String meaning;

    private String intonation;

    private String wordClass;

    private String explanation;

    private String noteId;

    public Vocab toEntity(Note note) {
        return Vocab.builder()
                .word(word)
                .meaning(meaning)
                .intonation(intonation)
                .wordClass(wordClass)
                .explanation(explanation)
                .note(note)
                .build();
    }

}

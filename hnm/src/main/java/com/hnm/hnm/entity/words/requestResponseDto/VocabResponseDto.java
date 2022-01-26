package com.hnm.hnm.entity.words.requestResponseDto;

import com.hnm.hnm.entity.words.Vocab;
import lombok.Getter;

@Getter
public class VocabResponseDto {

    private final Long vocabId;

    private final String word;

    private final String meaning;

    private final String intonation;

    private final String wordClass;

    private final String explanation;

    private VocabResponseDto(Vocab entity) {
        this.vocabId = entity.getId();
        this.word = entity.getWord();
        this.meaning = entity.getMeaning();
        this.intonation = entity.getIntonation();
        this.wordClass = entity.getWordClass();
        this.explanation = entity.getExplanation();
    }

    public static VocabResponseDto of(Vocab vocab) {
        return new VocabResponseDto(vocab);
    }
}

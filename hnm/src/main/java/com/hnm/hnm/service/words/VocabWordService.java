package com.hnm.hnm.service.words;

import com.hnm.hnm.entity.words.Note;
import com.hnm.hnm.entity.words.Vocab;
import com.hnm.hnm.entity.words.requestResponseDto.VocabRequestDto;
import com.hnm.hnm.entity.words.requestResponseDto.VocabResponseDto;
import com.hnm.hnm.repository.words.NoteRepository;
import com.hnm.hnm.repository.words.VocabWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VocabWordService {

    private final VocabWordRepository vocabWordRepository;
    private final NoteRepository noteRepository;

    @Transactional
    public VocabResponseDto makeVocab(VocabRequestDto vocabRequestDto) {
        Note note = noteRepository.findById(Long.valueOf(vocabRequestDto.getNoteId()))
                .orElseThrow(() -> new RuntimeException("해당 하는 노트가 없습니다."));

        Vocab vocab = vocabRequestDto.toEntity(note);

        return VocabResponseDto.of(vocabWordRepository.save(vocab));
    }

}

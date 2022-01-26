package com.hnm.hnm.controller.words;

import com.hnm.hnm.entity.words.requestResponseDto.VocabRequestDto;
import com.hnm.hnm.entity.words.requestResponseDto.VocabResponseDto;
import com.hnm.hnm.service.words.VocabWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vocabWord")
@RequiredArgsConstructor
public class VocabWordController {

    private final VocabWordService vocabWordService;

    @PostMapping("/makeVocab")
    public VocabResponseDto makeVocab(@RequestBody VocabRequestDto vocabRequestDto) {
        return vocabWordService.makeVocab(vocabRequestDto);
    }

}

package com.hnm.hnm.service.words;

import com.hnm.hnm.entity.words.Hsk;
import com.hnm.hnm.repository.words.HskWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HskWordService {

    private final HskWordRepository hskWordRepository;

    @Transactional(readOnly = true)
    public List<String> getHskThemeByLevel(int level) {
        return hskWordRepository.selectDistinctThemeByLevel(level);
    }

    @Transactional(readOnly = true)
    public List<Hsk> getHskWordsByLevelAndTheme(int level, String theme) {
        return hskWordRepository.findByLevelAndTheme(level, theme);
    }
}

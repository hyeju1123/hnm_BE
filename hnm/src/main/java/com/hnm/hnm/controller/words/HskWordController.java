package com.hnm.hnm.controller.words;

import com.hnm.hnm.entity.words.Hsk;
import com.hnm.hnm.service.words.HskWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hskWord")
@RequiredArgsConstructor
public class HskWordController {

    private final HskWordService hskWordService;

    @GetMapping("/getTheme")
    public List<String> getHskThemeByLevel(@RequestParam String hskLevel) {
        return hskWordService.getHskThemeByLevel(Integer.parseInt(hskLevel));
    }

    @GetMapping("/getWordsByLevel")
    public List<Hsk> getHskWordsByLevelAndTheme(@RequestParam String hskLevel, @RequestParam String theme) {
        return hskWordService.getHskWordsByLevelAndTheme(Integer.parseInt(hskLevel), theme);
    }

}

package com.hnm.hnm.service.words;

import com.hnm.hnm.entity.member.Member;
import com.hnm.hnm.entity.words.Note;
import com.hnm.hnm.jwtSecurity.SecurityUtil;
import com.hnm.hnm.repository.member.MemberRepository;
import com.hnm.hnm.repository.words.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final MemberRepository memberRepository;
    private final NoteRepository noteRepository;

    @Transactional
    public Note makeNote(String name) {
        Long currentMemberId = SecurityUtil.getCurrentMemberId();
        Member member = memberRepository.findById(currentMemberId)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

        Note note = Note.builder()
                .name(name)
                .member(member)
                .build();

        return noteRepository.save(note);
    }
}

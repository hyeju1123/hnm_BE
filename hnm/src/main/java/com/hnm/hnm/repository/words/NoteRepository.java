package com.hnm.hnm.repository.words;

import com.hnm.hnm.entity.words.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Override
    Optional<Note> findById(Long id);
}

package com.hnm.hnm.repository.words;

import com.hnm.hnm.entity.words.Hsk;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HskWordRepository extends JpaRepository<Hsk, Long> {


    @Query("SELECT DISTINCT h.theme FROM Hsk h WHERE h.level = :level")
    List<String> selectDistinctThemeByLevel(@Param("level") int level);


    List<Hsk> findByLevelAndTheme(int level, String theme);
}

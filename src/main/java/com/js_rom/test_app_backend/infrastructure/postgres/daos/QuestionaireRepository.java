package com.js_rom.test_app_backend.infrastructure.postgres.daos;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.js_rom.test_app_backend.infrastructure.postgres.entities.QuestionaireEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.QuestionaireSummary;

public interface QuestionaireRepository extends JpaRepository<QuestionaireEntity, String> {


    @Query("SELECT q.id AS id, q.description AS description FROM QuestionaireEntity q")
    public List<QuestionaireSummary> readAllBasicQuestionaire();
}

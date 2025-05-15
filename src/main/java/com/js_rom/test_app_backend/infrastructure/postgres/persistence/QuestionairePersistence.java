package com.js_rom.test_app_backend.infrastructure.postgres.persistence;

import org.springframework.stereotype.Repository;

import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.out_ports.QuestionairePersistenceAdapter;
import com.js_rom.test_app_backend.infrastructure.postgres.daos.QuestionaireRepository;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.QuestionaireEntity;

@Repository
public class QuestionairePersistence implements QuestionairePersistenceAdapter {

    QuestionaireRepository questionaireRepository;

    public QuestionairePersistence(QuestionaireRepository questionaireRepository) {
        this.questionaireRepository = questionaireRepository;
    }

    @Override
    public Questionaire create(Questionaire questionaire) {

        return this.questionaireRepository.save(new QuestionaireEntity(questionaire)).toQuestionaire();

    }

    @Override
    public void delete(String id) {
       this.questionaireRepository.deleteById(id);
    }

}

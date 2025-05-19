package com.js_rom.test_app_backend.domain.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.js_rom.test_app_backend.domain.in_ports.QuestionaireServiceAdapter;
import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;
import com.js_rom.test_app_backend.domain.out_ports.QuestionairePersistenceAdapter;

@Service
public class QuestionaireService implements QuestionaireServiceAdapter {

    QuestionairePersistenceAdapter questionairePersistence;

    public QuestionaireService(QuestionairePersistenceAdapter questionairePersistence) {
        this.questionairePersistence = questionairePersistence;
    }

    @Override
    public Questionaire create(Questionaire questionaire) {
        return this.questionairePersistence.create(questionaire);
    }

    @Override
    public void delete(String id) {
        this.questionairePersistence.delete(id);
    }

    @Override
    public SingleSelectionQuestion create(String questionaireId, SingleSelectionQuestion singleSelectionQuestion) {
        return this.questionairePersistence.create(questionaireId, singleSelectionQuestion);
    }

    @Override
    public List<Questionaire> readAll() {
        return this.questionairePersistence.readAll();
    }

}

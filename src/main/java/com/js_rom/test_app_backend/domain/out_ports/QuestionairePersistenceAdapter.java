package com.js_rom.test_app_backend.domain.out_ports;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

@Repository
public interface QuestionairePersistenceAdapter {

    public Questionaire create(Questionaire questionaire);

    public void delete(String id);

    public Questionaire readById(String id);

    public SingleSelectionQuestion create(String questionaireId, SingleSelectionQuestion singleSelectionQuestion);

    public List<Questionaire> readAll();

    public List<SingleSelectionQuestion> readAllQuestionByQuestionaireId(String id);
}

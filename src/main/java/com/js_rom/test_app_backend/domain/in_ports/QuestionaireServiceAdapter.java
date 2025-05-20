package com.js_rom.test_app_backend.domain.in_ports;

import java.util.List;

import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

public interface QuestionaireServiceAdapter {

    public Questionaire create(Questionaire questionaire);

    public void delete(String id);

    public SingleSelectionQuestion create(String questionaireId, SingleSelectionQuestion singleSelectionQuestion);

    public List<Questionaire> readAll();

    public List<SingleSelectionQuestion> readAllQuestionByQuestionaireId(String id);

    public Questionaire readBasicQuestionaireBy(String id);

}

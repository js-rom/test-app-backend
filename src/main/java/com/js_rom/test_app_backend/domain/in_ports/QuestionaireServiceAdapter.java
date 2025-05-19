package com.js_rom.test_app_backend.domain.in_ports;

import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

public interface QuestionaireServiceAdapter {

    public Questionaire create(Questionaire questionaire);

    public void delete(String id);

    public SingleSelectionQuestion create(String questionaireId, SingleSelectionQuestion singleSelectionQuestion);

}

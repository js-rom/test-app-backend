package com.js_rom.test_app_backend.domain.out_ports;

import com.js_rom.test_app_backend.domain.models.Questionaire;

public interface QuestionairePersistenceAdapter {

    public Questionaire create(Questionaire questionaire);
}

package com.js_rom.test_app_backend.domain.out_ports;

import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

public interface SingleSelectionQuestionPersistenceAdapter {

    public SingleSelectionQuestion updateQuestion(String id, SingleSelectionQuestion singleSelectionQuestion);
}

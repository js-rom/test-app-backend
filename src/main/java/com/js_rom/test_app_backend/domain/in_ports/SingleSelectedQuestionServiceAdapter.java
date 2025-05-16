package com.js_rom.test_app_backend.domain.in_ports;

import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

public interface SingleSelectedQuestionServiceAdapter {

    public SingleSelectionQuestion updateQuestion(String id, SingleSelectionQuestion singleSelectionQuestion);
}

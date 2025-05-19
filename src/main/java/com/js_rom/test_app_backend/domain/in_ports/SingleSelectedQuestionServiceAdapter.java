package com.js_rom.test_app_backend.domain.in_ports;

import org.springframework.stereotype.Service;

import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

@Service
public interface SingleSelectedQuestionServiceAdapter {

    public SingleSelectionQuestion update(String id, SingleSelectionQuestion singleSelectionQuestion);

    public void delete(String id);
}

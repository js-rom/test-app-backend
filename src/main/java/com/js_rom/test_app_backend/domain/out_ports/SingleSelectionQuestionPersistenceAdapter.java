package com.js_rom.test_app_backend.domain.out_ports;

import org.springframework.stereotype.Repository;

import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

@Repository
public interface SingleSelectionQuestionPersistenceAdapter {

    public SingleSelectionQuestion update(SingleSelectionQuestion singleSelectionQuestion);

    public SingleSelectionQuestion readById(String id);

    public void delete(String id);
}

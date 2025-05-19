package com.js_rom.test_app_backend.domain.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.js_rom.test_app_backend.domain.in_ports.SingleSelectedQuestionServiceAdapter;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;
import com.js_rom.test_app_backend.domain.out_ports.SingleSelectionQuestionPersistenceAdapter;

@Service
public class SingleSelectionQuestionService implements SingleSelectedQuestionServiceAdapter {

    SingleSelectionQuestionPersistenceAdapter singleSelectionQuestionPersistence;

    public SingleSelectionQuestionService(
            SingleSelectionQuestionPersistenceAdapter singleSelectionQuestionPersistence) {
        this.singleSelectionQuestionPersistence = singleSelectionQuestionPersistence;
    }

    @Override
    public SingleSelectionQuestion update(String id, SingleSelectionQuestion singleSelectionQuestion) {
        SingleSelectionQuestion newSingleSelectionQuestion = this.singleSelectionQuestionPersistence.readById(id);
        BeanUtils.copyProperties(singleSelectionQuestion, newSingleSelectionQuestion);
        newSingleSelectionQuestion.setOptions(singleSelectionQuestion.getOptions());
        return this.singleSelectionQuestionPersistence.update(newSingleSelectionQuestion);
    }

    @Override
    public void delete(String id) {
       this.singleSelectionQuestionPersistence.delete(id);
    }

}

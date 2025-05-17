package com.js_rom.test_app_backend.infrastructure.postgres.persistence;

import org.springframework.stereotype.Repository;

import com.js_rom.test_app_backend.domain.exceptions.NotFoundException;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;
import com.js_rom.test_app_backend.domain.out_ports.SingleSelectionQuestionPersistenceAdapter;
import com.js_rom.test_app_backend.infrastructure.postgres.daos.SingleSelectionQuestionRepository;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.SingleSelectionQuestionEntity;

@Repository
public class SingleSelectionQuestionPersistence implements SingleSelectionQuestionPersistenceAdapter {

    SingleSelectionQuestionRepository singleSelectionQuestionRepository;

    public SingleSelectionQuestionPersistence(SingleSelectionQuestionRepository singleSelectionQuestionRepository) {
        this.singleSelectionQuestionRepository = singleSelectionQuestionRepository;
    }

    @Override
    public SingleSelectionQuestion update(SingleSelectionQuestion singleSelectionQuestion) {
        SingleSelectionQuestionEntity singleSelectionQuestionEntity = this.singleSelectionQuestionRepository
                .findById(singleSelectionQuestion.getId()).orElseThrow(() -> new NotFoundException(
                        "Single selection question ID: " + singleSelectionQuestion.getId()));
        singleSelectionQuestionEntity.fromSingleSelectionQuestion(singleSelectionQuestion);
        return this.singleSelectionQuestionRepository.save(singleSelectionQuestionEntity).toSingleSelectionQuestion();
    }

    @Override
    public SingleSelectionQuestion readById(String id) {
        return this.singleSelectionQuestionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Single selection question ID: " + id))
                .toSingleSelectionQuestion();
    }

}

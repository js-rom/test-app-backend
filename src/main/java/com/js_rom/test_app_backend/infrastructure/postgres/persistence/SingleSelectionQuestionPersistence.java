package com.js_rom.test_app_backend.infrastructure.postgres.persistence;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Repository;

import com.js_rom.test_app_backend.domain.exceptions.NotFoundException;
import com.js_rom.test_app_backend.domain.models.CorrectOption;
import com.js_rom.test_app_backend.domain.models.IncorrectOption;
import com.js_rom.test_app_backend.domain.models.Option;
import com.js_rom.test_app_backend.domain.models.OptionVisitor;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;
import com.js_rom.test_app_backend.domain.out_ports.SingleSelectionQuestionPersistenceAdapter;
import com.js_rom.test_app_backend.infrastructure.postgres.daos.OptionRepository;
import com.js_rom.test_app_backend.infrastructure.postgres.daos.SingleSelectionQuestionRepository;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.CorrectOptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.IncorrectOptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.OptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.SingleSelectionQuestionEntity;

import jakarta.transaction.Transactional;

@Repository
public class SingleSelectionQuestionPersistence implements SingleSelectionQuestionPersistenceAdapter {

    SingleSelectionQuestionRepository singleSelectionQuestionRepository;
    OptionRepository optionRepository;

    public SingleSelectionQuestionPersistence(
            SingleSelectionQuestionRepository singleSelectionQuestionRepository,
            OptionRepository optionRepository) {

        this.singleSelectionQuestionRepository = singleSelectionQuestionRepository;
        this.optionRepository = optionRepository;
    }

    @Transactional
    @Override
    public SingleSelectionQuestion update(SingleSelectionQuestion singleSelectionQuestion) {
        SingleSelectionQuestionEntity singleSelectionQuestionEntity = this.singleSelectionQuestionRepository
                .findById(singleSelectionQuestion.getId()).orElseThrow(() -> new NotFoundException(
                        "Single selection question ID: " + singleSelectionQuestion.getId()));
        singleSelectionQuestionEntity.getOptions().clear();
        this.singleSelectionQuestionRepository.flush();
        singleSelectionQuestionEntity.fromSingleSelectionQuestion(singleSelectionQuestion);
        return this.singleSelectionQuestionRepository
                .save(singleSelectionQuestionEntity).toSingleSelectionQuestion();
    }

    @Override
    public SingleSelectionQuestion readById(String id) {
        return this.singleSelectionQuestionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Single selection question ID: " + id))
                .toSingleSelectionQuestion();
    }

}

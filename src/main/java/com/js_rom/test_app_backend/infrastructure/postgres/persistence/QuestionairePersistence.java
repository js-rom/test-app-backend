package com.js_rom.test_app_backend.infrastructure.postgres.persistence;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.js_rom.test_app_backend.domain.exceptions.NotFoundException;
import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;
import com.js_rom.test_app_backend.domain.out_ports.QuestionairePersistenceAdapter;
import com.js_rom.test_app_backend.infrastructure.postgres.daos.QuestionaireRepository;
import com.js_rom.test_app_backend.infrastructure.postgres.daos.SingleSelectionQuestionRepository;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.QuestionaireEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.SingleSelectionQuestionEntity;

import jakarta.transaction.Transactional;

@Repository
public class QuestionairePersistence implements QuestionairePersistenceAdapter {

    QuestionaireRepository questionaireRepository;
    SingleSelectionQuestionRepository singleSelectionQuestionRepository;

    public QuestionairePersistence(QuestionaireRepository questionaireRepository,
            SingleSelectionQuestionRepository singleSelectionQuestionRepository) {
        this.questionaireRepository = questionaireRepository;
        this.singleSelectionQuestionRepository = singleSelectionQuestionRepository;
    }

    @Override
    public Questionaire create(Questionaire questionaire) {

        return this.questionaireRepository.save(new QuestionaireEntity(questionaire)).toQuestionaire();

    }

    @Override
    public void delete(String id) {
        this.questionaireRepository.deleteById(id);
    }

    @Override
    public Questionaire readById(String id) {
        return this.questionaireRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quetionaire ID: " + id))
                .toQuestionaire();
    }

    @Override
    public SingleSelectionQuestion create(String questionaireId, SingleSelectionQuestion singleSelectionQuestion) {
        QuestionaireEntity questionaireEntity = this.questionaireRepository.findById(questionaireId)
                .orElseThrow(() -> new NotFoundException("Quetionaire ID: " + questionaireId));
        SingleSelectionQuestionEntity newSingleSelectionQuestionEntity = new SingleSelectionQuestionEntity(
                singleSelectionQuestion);
        questionaireEntity.add(newSingleSelectionQuestionEntity);
        this.questionaireRepository.save(questionaireEntity);
        return this.singleSelectionQuestionRepository.findById(newSingleSelectionQuestionEntity.getId())
                .orElseThrow(() -> new NotFoundException("Quetion ID: " + newSingleSelectionQuestionEntity.getId()))
                .toSingleSelectionQuestion();
    }

    @Override
    public List<Questionaire> readAll() {
        return this.questionaireRepository.readAllBasicQuestionaire().stream()
                .map(questionaireSummary -> {
                    Questionaire questionaire = new Questionaire();
                    questionaire.setId(questionaireSummary.getId());
                    questionaire.setDescription(questionaireSummary.getDescription());
                    return questionaire;
                }).toList();
    }

    @Override
    public List<SingleSelectionQuestion> readAllQuestionByQuestionaireId(String id) {
        Questionaire questionaire = this.readById(id);
        return questionaire.getSingleSelectionQuestions();
    }

}

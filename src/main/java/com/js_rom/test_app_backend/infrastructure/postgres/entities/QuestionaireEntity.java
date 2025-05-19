package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class QuestionaireEntity {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String description;
    @Singular
    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinColumn(name = "questionaire_entity_id")
    private List<SingleSelectionQuestionEntity> singleSelectionQuestions;

    public QuestionaireEntity(Questionaire questionaire) {
        BeanUtils.copyProperties(questionaire, this);
        this.id = UUID.randomUUID().toString();
        if (Objects.nonNull(questionaire.getSingleSelectionQuestions())) {
            this.singleSelectionQuestions = questionaire.getSingleSelectionQuestions().stream()
                    .map(SingleSelectionQuestionEntity::new)
                    .toList();
        }
    }

    public Questionaire toQuestionaire() {
        Questionaire questionaire = new Questionaire();
        BeanUtils.copyProperties(this, questionaire);
        List<SingleSelectionQuestion> domainSingleSelectionQuestions = this.singleSelectionQuestions.stream()
                .map(SingleSelectionQuestionEntity::toSingleSelectionQuestion).toList();
        questionaire.setSingleSelectionQuestions(domainSingleSelectionQuestions);
        return questionaire;
    }

    public void fromQuestionaire(Questionaire questionaire) {
        BeanUtils.copyProperties(questionaire, this);
        /* if (Objects.nonNull(questionaire.getSingleSelectionQuestions())) {
            this.singleSelectionQuestions = questionaire.getSingleSelectionQuestions().stream()
                    .map(SingleSelectionQuestionEntity::new).toList();
        } */
    }

    public void add(SingleSelectionQuestionEntity singleSelectionQuestionEntity) {
        this.singleSelectionQuestions.add(singleSelectionQuestionEntity);
    }

}

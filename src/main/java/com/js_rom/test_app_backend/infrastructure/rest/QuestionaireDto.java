package com.js_rom.test_app_backend.infrastructure.rest;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuestionaireDto {

    private String id;
    private String description;
    private List<SingleSelectionQuestionDto> singleSelectionQuestionDtos;

    public QuestionaireDto(Questionaire questionaire) {
        BeanUtils.copyProperties(questionaire, this);
        this.singleSelectionQuestionDtos = questionaire.getSingleSelectionQuestions().stream()
                .map(SingleSelectionQuestionDto::new).toList();
    }

    public Questionaire toQuestionaire() {
        Questionaire questionaire = new Questionaire();
        BeanUtils.copyProperties(this, questionaire);
        List<SingleSelectionQuestion> singleSelectionQuestion = this.singleSelectionQuestionDtos.stream()
                .map(SingleSelectionQuestionDto::toSingleSelectionQuestion).toList();
        questionaire.setSingleSelectionQuestions(singleSelectionQuestion);
        return questionaire;
    }
}

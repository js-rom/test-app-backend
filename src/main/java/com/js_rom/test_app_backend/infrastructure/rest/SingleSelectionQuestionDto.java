package com.js_rom.test_app_backend.infrastructure.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.BeanUtils;

import com.js_rom.test_app_backend.domain.models.CorrectOption;
import com.js_rom.test_app_backend.domain.models.Option;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SingleSelectionQuestionDto {

    String id;
    String description;
    Integer correctOptionIndex;
    List<OptionDto> options;

    public SingleSelectionQuestionDto(SingleSelectionQuestion singleSelectionQuestion) {
        BeanUtils.copyProperties(singleSelectionQuestion, this);
        List<Option> domainOptions = singleSelectionQuestion.getOptions();
        Option correctOption = domainOptions.stream().filter(Option::isCorrect).findFirst().orElse(null);
        this.correctOptionIndex = domainOptions.indexOf(correctOption);
        this.options = domainOptions.stream().map(OptionDto::new).toList();
    }

    public SingleSelectionQuestion toSingleSelectionQuestion() {
        SingleSelectionQuestion singleSelectionQuestion = new SingleSelectionQuestion();
        BeanUtils.copyProperties(this, singleSelectionQuestion);
        AtomicInteger index = new AtomicInteger(0);
        List<Option> domainOptions = this.options.stream()
                .map(optionDto -> index.getAndIncrement() == this.correctOptionIndex ? optionDto.toCorrectOption()
                        : optionDto.toIncorrectOption())
                .toList();
        singleSelectionQuestion.setOptions(domainOptions);
        return singleSelectionQuestion;
    }
}

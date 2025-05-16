package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;

import com.js_rom.test_app_backend.domain.models.CorrectOption;
import com.js_rom.test_app_backend.domain.models.IncorrectOption;
import com.js_rom.test_app_backend.domain.models.Option;
import com.js_rom.test_app_backend.domain.models.OptionVisitor;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Builder
public class SingleSelectionQuestionEntity {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String description;
    @Singular
    @OneToMany(cascade = CascadeType.ALL)
    private List<OptionEntity> options;

    SingleSelectionQuestionEntity() {
        this.id = UUID.randomUUID().toString();
    }

    SingleSelectionQuestionEntity(SingleSelectionQuestion singleSelectionQuestion) {
        this.id = UUID.randomUUID().toString();
        BeanUtils.copyProperties(singleSelectionQuestion, this);
        if (Objects.nonNull(singleSelectionQuestion.getOptions())) {
            Visitor visitor = new Visitor();
            this.options = singleSelectionQuestion.getOptions().stream()
                    .map(visitor).toList();
        }
    }

    class Visitor implements Function<Option, OptionEntity>, OptionVisitor {

        OptionEntity option;

        public OptionEntity apply(Option option) {
            option.accept(this);
            return this.option;
        }

        @Override
        public void visit(CorrectOption correctOption) {
            CorrectOptionEntity correctOptionEntity = new CorrectOptionEntity(correctOption);
            this.option = correctOptionEntity;
        }

        @Override
        public void visit(IncorrectOption incorrectOption) {
            IncorrectOptionEntity incorrectOptionEntity = new IncorrectOptionEntity(incorrectOption);
            this.option = incorrectOptionEntity;
        }
    }

}

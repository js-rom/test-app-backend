package com.js_rom.test_app_backend.infrastructure.postgres.entities;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
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
           // TODO 
        }
    }
}

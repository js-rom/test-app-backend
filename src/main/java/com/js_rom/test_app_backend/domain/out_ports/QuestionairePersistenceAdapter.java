package com.js_rom.test_app_backend.domain.out_ports;

import org.springframework.stereotype.Repository;

import com.js_rom.test_app_backend.domain.models.Questionaire;

@Repository
public interface QuestionairePersistenceAdapter {

    public Questionaire create(Questionaire questionaire);

    public void delete(String id);

    public Questionaire readById(String id);

}

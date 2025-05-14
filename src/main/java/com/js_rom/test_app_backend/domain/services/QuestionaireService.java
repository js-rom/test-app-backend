package com.js_rom.test_app_backend.domain.services;

import org.springframework.stereotype.Service;

import com.js_rom.test_app_backend.domain.in_ports.QuestionaireServiceAdapter;
import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.out_ports.QuestionairePersistenceAdapter;

@Service
public class QuestionaireService implements QuestionaireServiceAdapter {

    QuestionairePersistenceAdapter questionairePersistence;

    public QuestionaireService(QuestionairePersistenceAdapter questionairePersistence){
        this.questionairePersistence = questionairePersistence;
    }

    @Override
    public Questionaire create(Questionaire questionaire) {
       return this.questionairePersistence.create(questionaire);
    }

}

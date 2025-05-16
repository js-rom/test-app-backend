package com.js_rom.test_app_backend.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(SingleSelectionQuestionResource.SINGLE_SELECTION_QUESTION)
public class SingleSelectionQuestionResource {

        static final String SINGLE_SELECTION_QUESTION = "/questionaire/single-selection-questions";
        static final String ID_ID = "/{id}";

        @PutMapping(ID_ID)
        public String putMethodName(@PathVariable String id, @RequestBody String entity) {
            //TODO: process PUT request
            
            return entity;
        }
}

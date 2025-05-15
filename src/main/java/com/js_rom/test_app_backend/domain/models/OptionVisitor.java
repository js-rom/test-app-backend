package com.js_rom.test_app_backend.domain.models;

public interface OptionVisitor {

    public void visit(CorrectOption correctOption);

    public void visit(IncorrectOption incorrectOption);
}

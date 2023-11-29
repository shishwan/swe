package com.gmu.hw.survey.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SurveyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public SurveyException(String message) {
        super(message);
    }
}

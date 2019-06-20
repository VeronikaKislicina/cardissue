package com.decta.homework.cardissue.validation;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public Validation validate() {
        return Math.random() < 0.5 ? Validation.VALID : Validation.NOT_VALID;
    }

}


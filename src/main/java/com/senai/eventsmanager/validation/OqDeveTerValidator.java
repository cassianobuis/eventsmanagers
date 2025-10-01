package com.senai.eventsmanager.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OqDeveTerValidator implements ConstraintValidator<OqDeveTer, String>{

    

    private static final String PALAVRA_ARABE = "الأفق";

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
        if (valor == null) return false;
        return valor.contains(PALAVRA_ARABE);
    }
}

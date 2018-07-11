package com.mycompany.descorpv2.ejb.entidades;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target( {ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorPais.class)
@Documented
public @interface ValidaPais {
    String message() default "{com.mycompany.descorp.Artista.pais}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
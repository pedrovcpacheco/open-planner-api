package br.edu.ifpb.mestrado.openplanner.api.infrastructure.persistence.hibernate.specification;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ FIELD })
public @interface SpecField {

    /**
     * Nome da propriedade
     */
    public String value() default "";

    public Operation operation() default Operation.EQUAL;

}

package com.realdolmen.course.controller.Validators;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by heleneshaikh on 07/03/16.
 */

@Target({ElementType.METHOD, ElementType.FIELD}) //annotation type is applicable to
@Retention(RetentionPolicy.RUNTIME) //how long the annotation has to be retained
@Constraint(validatedBy = Email.EmailConstraintValidator.class) //Marks an annotation as being a Bean Validation constraint.

public @interface Email {
    // Needs to have 3 attributes: message, groups, payload

    String message() default "Error validating email address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Created by heleneshaikh on 07/03/16.
     */
    class EmailConstraintValidator implements ConstraintValidator<org.hibernate.validator.constraints.Email, String> {
        private static final String DOMAIN_SUFFIX = "@gmail.com";

        @Override
        public void initialize(org.hibernate.validator.constraints.Email constraintAnnotation) {

        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value != null
                    && !value.trim().equals("")
                    && value.endsWith(DOMAIN_SUFFIX)
                    && !value.startsWith(DOMAIN_SUFFIX);
        }
    }
}

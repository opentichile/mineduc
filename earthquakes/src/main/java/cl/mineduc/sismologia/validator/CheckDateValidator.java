package cl.mineduc.sismologia.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * 
 * Validador de Fecha
 * 
 * @author Alejandro Sandoval S.
 *
 */
public class CheckDateValidator implements ConstraintValidator<CheckDateFormat, String> {

    private String pattern;

    @Override
    public void initialize(CheckDateFormat constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext){
        if ( object == null ) {
            return true;
        }

        try {
            Date date = new SimpleDateFormat(pattern).parse(object);
            System.out.println(date);
            return true;
        } catch (ParseException e) {
           return true;
        }
    }
}
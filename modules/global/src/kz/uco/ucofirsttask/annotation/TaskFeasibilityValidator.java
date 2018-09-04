package kz.uco.ucofirsttask.annotation;

import kz.uco.ucofirsttask.entity.Contact;
import kz.uco.ucofirsttask.entity.ContactType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskFeasibilityValidator implements ConstraintValidator<CheckContactValidity, Contact> {
    @Override
    public void initialize(CheckContactValidity constraintAnnotation) {

    }

    @Override
    public boolean isValid(Contact value, ConstraintValidatorContext context) {
        if (value.getContactType()== ContactType.email) {
            String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
            Matcher matcher = Pattern.compile(regex).matcher(value.getValue());
            return matcher.matches();
        } else if (value.getContactType()==ContactType.phone) {
            String regex = "[+]\\d{1,3}[(]\\d{3}[)]\\d{7}";
            Matcher matcher = Pattern.compile(regex).matcher(value.getValue());
            return matcher.matches();
        } else {
            return false;
        }
    }
}

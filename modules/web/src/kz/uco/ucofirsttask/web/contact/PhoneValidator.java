package kz.uco.ucofirsttask.web.contact;

import com.haulmont.cuba.gui.components.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements Field.Validator {

    public static final String phoneRegex = "[+]\\d{1}[(]\\d{3}[)]\\d{3}[-]\\d{2}[-]\\d{2}";

    @Override
    public void validate(Object value) throws ValidationException {
        String phone = (String) value;
        Matcher matcher = Pattern.compile(phoneRegex).matcher(phone);
        if (!matcher.matches()) {
            throw new ValidationException("Wrong phone format");
        }
    }
}

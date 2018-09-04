package kz.uco.ucofirsttask.web.contact;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.ValidationErrors;
import kz.uco.ucofirsttask.entity.Contact;
import kz.uco.ucofirsttask.entity.ContactType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactEdit extends AbstractEditor<Contact> {
    @Override
    protected void postValidate(ValidationErrors errors) {
        super.postValidate(errors);
        Contact contact = getItem();

        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

        String phoneRegex = "[+]\\d{1,3}[(]\\d{3}[)]\\d{7}";

        if (contact.getContactType() == ContactType.email) {
            Matcher matcher = Pattern.compile(emailRegex).matcher(contact.getValue());
            if (!matcher.matches()) {
                errors.add("Wrong email format");
            }
        }

        if (contact.getContactType() == ContactType.phone) {
            Matcher matcher = Pattern.compile(phoneRegex).matcher(contact.getValue());
            if (!matcher.matches()) {
                errors.add("Wrong phone format");
            }
        }
    }
}
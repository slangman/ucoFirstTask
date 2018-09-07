package kz.uco.ucofirsttask.web.contact;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import kz.uco.ucofirsttask.entity.Account;
import kz.uco.ucofirsttask.entity.Contact;
import kz.uco.ucofirsttask.entity.ContactType;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactEdit extends AbstractEditor<Contact> {

    @Inject
    private Datasource<Account> accountDs;
    @Inject
    private Datasource<Contact> contactDs;
    @Inject
    private Metadata metadata;
    @Inject
    private FieldGroup fieldGroup;
    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        getDialogOptions()
                .setWidth("400px") // fixed width
                .setHeight("400px")
                .setForceDialog(true); // always open as a dialog

        contactDs.addItemPropertyChangeListener(e -> {

            if (e.getItem().getContactType() == ContactType.email) {
                fieldGroup.getField("phone").setVisible(false);
                fieldGroup.getField("email").setVisible(true);
            }
            if (e.getItem().getContactType() == ContactType.phone) {
                fieldGroup.getField("email").setVisible(false);
                fieldGroup.getField("phone").setVisible(true);;
            }
        });
    }



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

    }

}
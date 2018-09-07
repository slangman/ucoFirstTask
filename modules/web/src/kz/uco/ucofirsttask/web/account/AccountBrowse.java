package kz.uco.ucofirsttask.web.account;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.GroupDatasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.vaadin.data.fieldgroup.Caption;
import kz.uco.ucofirsttask.entity.Account;

import javax.inject.Inject;
import java.util.Map;

public class AccountBrowse extends AbstractLookup {

    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private GroupTable<Account> accountsTable;

    @Inject
    private GroupDatasource accountsDs;

    @Inject
    private Button ordersBtn;


    @Override
    public void init(Map<String, Object> params) {

        accountsTable.addGeneratedColumn("imageFile", entity -> {
            Image imageFile = componentsFactory.createComponent(Image.class);
            imageFile.setScaleMode(Image.ScaleMode.CONTAIN);
            imageFile.setHeight("40");
            imageFile.setWidth("40");
            FileDescriptor accountImageFile = entity.getImageFile();
            imageFile.setSource(FileDescriptorResource.class).setFileDescriptor(accountImageFile);
            imageFile.setAlignment(Alignment.MIDDLE_CENTER);
            HBoxLayout hBox = componentsFactory.createComponent(HBoxLayout.class);
            hBox.setSpacing(true);
            hBox.add(imageFile);

            return hBox;
        });

        accountsTable.addGeneratedColumn("name", entity -> {
            Label name = componentsFactory.createComponent(Label.class);
            name.setValue(entity.getFName() + " " + entity.getLName());
            name.setAlignment(Alignment.MIDDLE_LEFT);
            HBoxLayout hBox = componentsFactory.createComponent(HBoxLayout.class);
            hBox.setSpacing(true);
            hBox.add(name);

            return hBox;
        });

        accountsTable.getColumn("name").setCaption("Name");
        accountsTable.getColumn("imageFile").setCaption("Image");
        ordersBtn.setEnabled(false);

        accountsDs.addItemChangeListener(e -> {
            Account account = accountsTable.getSingleSelected();
            if (account != null) {
                ordersBtn.setEnabled(true);
            } else {
                ordersBtn.setEnabled(false);
            }
        });

    }

    public void openOrdersPage() {
        openWindow("AccountOrders", WindowManager.OpenType.THIS_TAB, ParamsMap.of("account", accountsTable.getSingleSelected()));
    }

}
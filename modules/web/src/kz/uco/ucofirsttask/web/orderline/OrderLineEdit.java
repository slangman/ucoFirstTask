package kz.uco.ucofirsttask.web.orderline;

import com.haulmont.cuba.gui.components.AbstractEditor;
import kz.uco.ucofirsttask.entity.OrderLine;

import java.util.Map;

public class OrderLineEdit extends AbstractEditor<OrderLine> {

    @Override
    public void init(Map<String, Object> params) {
        getDialogOptions()
                .setWidth("400px") // fixed width
                .setHeight("400px")
                .setForceDialog(true); // always open as a dialog
    }

}
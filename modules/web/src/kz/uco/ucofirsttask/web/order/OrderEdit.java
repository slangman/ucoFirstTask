package kz.uco.ucofirsttask.web.order;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Field;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import kz.uco.ucofirsttask.entity.Order;
import kz.uco.ucofirsttask.entity.OrderLine;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public class OrderEdit extends AbstractEditor<Order> {

    @Inject
    private CollectionDatasource<OrderLine, UUID> linesDs;

    @Inject
    private FieldGroup fieldGroup;

    @Override
    public void init(Map<String, Object> params) {
        linesDs.addCollectionChangeListener(e -> calculateAmount());
        fieldGroup.getField("amount").setEditable(false);
    }

    public void calculateAmount() {
        BigDecimal amount = BigDecimal.ZERO;
        for (OrderLine line : linesDs.getItems()) {
            amount = amount.add(line.getProduct().getPrice().multiply(line.getQuantity()));
        }
        getItem().setAmount(amount);
    }
}
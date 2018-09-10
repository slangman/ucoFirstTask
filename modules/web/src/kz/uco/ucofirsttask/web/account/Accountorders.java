package kz.uco.ucofirsttask.web.account;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import kz.uco.ucofirsttask.entity.Account;
import kz.uco.ucofirsttask.entity.Order;
import kz.uco.ucofirsttask.entity.OrderLine;

import javax.inject.Inject;
import java.util.Map;

public class Accountorders extends AbstractWindow {

    @Inject
    Label pageLabel;

    @Inject
    CollectionDatasource ordersDs;

    @Inject
    CollectionDatasource orderLinesDs;

    @Inject
    Table<Order> ordersTable;

    @Inject
    Table<OrderLine> orderLinesTable;

    @WindowParam
    private Account account;

    @Override
    public void init(Map<String, Object> params) {

        orderLinesTable.setItemClickAction(new BaseAction("enterPressAction") {
            @Override
            public void actionPerform(Component component) {
                OrderLine orderLine = orderLinesTable.getSingleSelected();
                if (orderLine != null) {
                    openWindow("product-view", WindowManager.OpenType.THIS_TAB,
                            ParamsMap.of("product", orderLinesTable.getSingleSelected().getProduct())
                    );
                }
            }
        });

    }

}
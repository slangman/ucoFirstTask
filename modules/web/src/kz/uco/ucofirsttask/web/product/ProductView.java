package kz.uco.ucofirsttask.web.product;

import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import kz.uco.ucofirsttask.entity.Account;
import kz.uco.ucofirsttask.entity.Contact;
import kz.uco.ucofirsttask.entity.Product;

import javax.inject.Inject;
import java.util.Map;

public class ProductView extends AbstractWindow {

    @Inject
    private Image productImage;
    @Inject
    Label productName;
    @Inject
    Label productDescription;
    @WindowParam
    private Product product;
    /*@Inject
    private Datasource<Product> productDs;*/

    @Override
    public void init (Map<String, Object> params) {
        getDialogOptions()
                .setWidth("400px")
                .setHeight("300px")
                .setForceDialog(true); // always open as a dialog

        productName.setValue("Product name: " + product.getName());
        productDescription.setValue("Description: " + product.getDescription());

        if (product.getImageFile() != null) {
            productImage.setSource(FileDescriptorResource.class).setFileDescriptor(product.getImageFile());
            productImage.setVisible(true);
        } else {
            productImage.setVisible(false);
        }

    }

}
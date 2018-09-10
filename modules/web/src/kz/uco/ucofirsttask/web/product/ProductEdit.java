package kz.uco.ucofirsttask.web.product;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import kz.uco.ucofirsttask.entity.Account;
import kz.uco.ucofirsttask.entity.Contact;
import kz.uco.ucofirsttask.entity.Product;

import javax.inject.Inject;
import java.util.Map;

public class ProductEdit extends AbstractEditor<Product> {

    @Inject
    private ExportDisplay exportDisplay;
    @Inject
    private Button downloadImageBtn;
    @Inject
    private Button clearImageBtn;
    @Inject
    private Image productImage;
    @Inject
    private FileUploadField uploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataSupplier dataSupplier;
    @Inject
    private Datasource<Contact> productDs;

    @Override
    public void init(Map<String, Object> params) {

        uploadField.addFileUploadSucceedListener(event -> {
            FileDescriptor fd = uploadField.getFileDescriptor();
            try {
                fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fd);
            } catch (FileStorageException e) {
                throw new RuntimeException("Error saving file to FileStorage", e);
            }
            getItem().setImageFile(dataSupplier.commit(fd));
            displayImage();
        });

        uploadField.addFileUploadErrorListener(event ->
                showNotification("File upload error", NotificationType.HUMANIZED));

        productDs.addItemPropertyChangeListener(event -> {
            if ("imageFile".equals(event.getProperty()))
                updateImageButtons(event.getValue() != null);
        });

    }

    @Override
    protected void postInit() {
        displayImage();
        updateImageButtons(getItem().getImageFile() != null);
    }

    public void onDownloadImageBtnClick() {
        if (getItem().getImageFile() != null)
            exportDisplay.show(getItem().getImageFile(), ExportFormat.OCTET_STREAM);
    }

    public void onClearImageBtnClick() {
        getItem().setImageFile(null);
        displayImage();
    }

    private void updateImageButtons(boolean enable) {
        downloadImageBtn.setEnabled(enable);
        clearImageBtn.setEnabled(enable);
    }

    private void displayImage() {
        if (getItem().getImageFile() != null) {
            productImage.setScaleMode(Image.ScaleMode.SCALE_DOWN);
            productImage.setWidth("100%");
            //productImage.setHeight("300px");
            productImage.setSource(FileDescriptorResource.class).setFileDescriptor(getItem().getImageFile());
            productImage.setVisible(true);
        } else {
            productImage.setVisible(false);
        }
    }

}
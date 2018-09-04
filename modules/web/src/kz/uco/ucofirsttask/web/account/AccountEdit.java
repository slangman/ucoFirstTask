package kz.uco.ucofirsttask.web.account;

import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import kz.uco.ucofirsttask.entity.Account;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.app.security.user.edit.UserEditor;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
import java.util.Map;

public class AccountEdit extends AbstractEditor<Account> {

        @Inject
        private DataSupplier dataSupplier;
        @Inject
        private FileUploadingAPI fileUploadingAPI;
        @Inject
        private ExportDisplay exportDisplay;
        @Inject
        private FileUploadField uploadField;
        @Inject
        private Button downloadImageBtn;
        @Inject
        private Button clearImageBtn;
        @Inject
        private Datasource<Account> accountDs;

        @Inject
        private Image accountImage;

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

            accountDs.addItemPropertyChangeListener(event -> {
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
                accountImage.setSource(FileDescriptorResource.class).setFileDescriptor(getItem().getImageFile());
                accountImage.setVisible(true);
            } else {
                //return;
                accountImage.setVisible(false);
            }
        }

    /*public static final String DEFAULT_USER_IMAGE_PATH = "/kz/uco/ucofirsttask/web/account/default-avatar.jpg";

    @Inject
    private DataSupplier dataSupplier;

    @Inject
    private FileUploadField userImageUpload;

    @Inject
    private FileUploadingAPI fileUploadingAPI;

    @Inject
    private Image userImage;

    @Override
    public void init(Map<String, Object> params) {
        userImageUpload.addFileUploadSucceedListener(event -> {
            FileDescriptor fd = userImageUpload.getFileDescriptor();
            try {
                fileUploadingAPI.putFileIntoStorage(userImageUpload.getFileId(), fd);
            } catch (FileStorageException e) {
                throw new RuntimeException("Error saving file to FileStorage", e);
            }

            FileDescriptor committedImage = dataSupplier.commit(fd);
            userImage.setSource(FileDescriptorResource.class).setFileDescriptor(committedImage);

            ((Account) getItem()).setImageFile(committedImage);

            showNotification(formatMessage(getMessage("uploadSuccessMessage"), userImageUpload.getFileName()),
                    NotificationType.HUMANIZED);
        });

        super.init(params);
    }

    @Override
    protected void postInit() {
        super.postInit();

        FileDescriptor userImageFile = ((Account) getItem()).getImageFile();
        if (userImageFile == null) {
            userImage.setSource(ClasspathResource.class).setPath(AccountEdit.DEFAULT_USER_IMAGE_PATH);
        } else {
            userImage.setSource(FileDescriptorResource.class).setFileDescriptor(userImageFile);
        }
    }*/
}
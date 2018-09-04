package kz.uco.ucofirsttask.web.account;

import com.haulmont.cuba.gui.data.DataSupplier;
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

            ((Account) getItem()).setImage(committedImage);

            showNotification(formatMessage(getMessage("uploadSuccessMessage"), userImageUpload.getFileName()),
                    NotificationType.HUMANIZED);
        });

        super.init(params);
    }
}
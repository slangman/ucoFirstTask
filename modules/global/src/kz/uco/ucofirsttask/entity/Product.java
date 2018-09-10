package kz.uco.ucofirsttask.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "UCOFIRSTTASK_PRODUCT")
@Entity(name = "ucofirsttask$Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = 6816506203250411080L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "DESCRIPTION", length = 1024)
    protected String description;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_FILE_ID")
    protected FileDescriptor imageFile;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setImageFile(FileDescriptor imageFile) {
        this.imageFile = imageFile;
    }

    public FileDescriptor getImageFile() {
        return imageFile;
    }
}
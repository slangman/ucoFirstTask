package kz.uco.ucofirsttask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|qwe")
@Table(name = "UCOFIRSTTASK_ASDSD")
@Entity(name = "ucofirsttask$Asdsd")
public class Asdsd extends StandardEntity {
    private static final long serialVersionUID = -8388136899898110580L;

    @Column(name = "QWE")
    protected String qwe;

    public void setQwe(String qwe) {
        this.qwe = qwe;
    }

    public String getQwe() {
        return qwe;
    }


}
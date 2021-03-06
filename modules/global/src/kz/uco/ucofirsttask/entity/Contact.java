package kz.uco.ucofirsttask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import kz.uco.ucofirsttask.annotation.CheckContactValidity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.validation.constraints.NotNull;

//@CheckContactValidity
@Table(name = "UCOFIRSTTASK_CONTACT")
@Entity(name = "ucofirsttask$Contact")
public class Contact extends StandardEntity {
    private static final long serialVersionUID = 1214950608658114867L;

    @NotNull
    @Column(name = "CONTACT_TYPE", nullable = false)
    protected Integer contactType;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    protected Account account;

    @Column(name = "VALUE_")
    protected String value;

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }


    public ContactType getContactType() {
        return contactType == null ? null : ContactType.fromId(contactType);
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType == null ? null : contactType.getId();
    }


    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
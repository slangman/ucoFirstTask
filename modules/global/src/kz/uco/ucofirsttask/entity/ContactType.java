package kz.uco.ucofirsttask.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ContactType implements EnumClass<Integer> {

    email(10),
    phone(20);

    private Integer id;

    ContactType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static ContactType fromId(Integer id) {
        for (ContactType at : ContactType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
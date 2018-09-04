-- begin UCOFIRSTTASK_ACCOUNT
create table UCOFIRSTTASK_ACCOUNT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    F_NAME varchar(255) not null,
    M_NAME varchar(255),
    L_NAME varchar(255) not null,
    IMAGE_FILE_ID uuid,
    --
    primary key (ID)
)^
-- end UCOFIRSTTASK_ACCOUNT
-- begin UCOFIRSTTASK_CONTACT
create table UCOFIRSTTASK_CONTACT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CONTACT_TYPE integer,
    ACCOUNT_ID uuid,
    VALUE_ varchar(255),
    --
    primary key (ID)
)^
-- end UCOFIRSTTASK_CONTACT

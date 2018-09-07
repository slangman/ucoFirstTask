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
    CONTACT_TYPE integer not null,
    ACCOUNT_ID uuid,
    VALUE_ varchar(255),
    --
    primary key (ID)
)^
-- end UCOFIRSTTASK_CONTACT
-- begin UCOFIRSTTASK_PRODUCT
create table UCOFIRSTTASK_PRODUCT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION varchar(1024),
    PRICE decimal(19, 2) not null,
    IMAGE_FILE_ID uuid,
    --
    primary key (ID)
)^
-- end UCOFIRSTTASK_PRODUCT
-- begin UCOFIRSTTASK_ORDER
create table UCOFIRSTTASK_ORDER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_ date not null,
    AMOUNT decimal(19, 2) not null,
    ACCOUNT_ID uuid not null,
    --
    primary key (ID)
)^
-- end UCOFIRSTTASK_ORDER
-- begin UCOFIRSTTASK_ORDER_LINE
create table UCOFIRSTTASK_ORDER_LINE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID uuid,
    PRODUCT_ID uuid,
    QUANTITY decimal(19, 3),
    --
    primary key (ID)
)^
-- end UCOFIRSTTASK_ORDER_LINE
-- begin UCOFIRSTTASK_ASDSD
create table UCOFIRSTTASK_ASDSD (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    QWE varchar(255),
    --
    primary key (ID)
)^
-- end UCOFIRSTTASK_ASDSD

alter table UCOFIRSTTASK_CONTACT add constraint FK_UCOFIRSTTASK_CONTACT_ON_ACCOUNT foreign key (ACCOUNT_ID) references UCOFIRSTTASK_ACCOUNT(ID);
create index IDX_UCOFIRSTTASK_CONTACT_ON_ACCOUNT on UCOFIRSTTASK_CONTACT (ACCOUNT_ID);

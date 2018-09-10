update UCOFIRSTTASK_CONTACT set CONTACT_TYPE = 10 where CONTACT_TYPE is null ;
alter table UCOFIRSTTASK_CONTACT alter column CONTACT_TYPE set not null ;

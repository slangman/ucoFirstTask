-- update UCOFIRSTTASK_ORDER set ACCOUNT_ID = <default_value> where ACCOUNT_ID is null ;
alter table UCOFIRSTTASK_ORDER alter column ACCOUNT_ID set not null ;

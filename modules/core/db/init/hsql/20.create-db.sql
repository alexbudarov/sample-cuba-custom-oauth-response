-- begin EXTTOK_USER_DETAILS
alter table EXTTOK_USER_DETAILS add constraint FK_EXTTOK_USER_DETAILS_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
create unique index IDX_EXTTOK_USER_DETAILS_UNIQ_USER_ID on EXTTOK_USER_DETAILS (USER_ID)^
create index IDX_EXTTOK_USER_DETAILS_ON_USER on EXTTOK_USER_DETAILS (USER_ID)^
-- end EXTTOK_USER_DETAILS

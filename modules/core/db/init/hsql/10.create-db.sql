-- begin EXTTOK_USER_DETAILS
create table EXTTOK_USER_DETAILS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36),
    PHONE_NUMBER varchar(255),
    --
    primary key (ID)
)^
-- end EXTTOK_USER_DETAILS

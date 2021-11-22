-- drop tables
drop table if exists ORDER_DETAIL;
drop table if exists SALES_ORDER;
drop table if exists PRICE;
drop table if exists PRODUCT_CATEGORY;
drop table if exists PRODUCT_BRAND;
drop table if exists PRODUCT_COLOR;
drop table if exists ACCOUNT;
drop table if exists CATEGORY;
drop table if exists COLOR;
drop table if exists BRAND;
drop table if exists PRODUCT;


-- Create table
create table ACCOUNT
(
  USER_NAME VARCHAR(20) not null,
  ACTIVE    BIT not null,
  ENCRYTED_PASSWORD  VARCHAR(128) not null,
  USER_ROLE VARCHAR(20) not null,
  PRIMARY KEY  (USER_NAME)
) ;

-- -------------------------------------
create table CATEGORY
(
  CODE        VARCHAR(20) not null,
  NAME        VARCHAR(128) not null,
  DESCRIPTION VARCHAR(255) not null,
  PRIMARY KEY  (CODE)

) ;

-- -------------------------------------
create table COLOR
(
  CODE        VARCHAR(20) not null,
  NAME        VARCHAR(128) not null,
  DESCRIPTION VARCHAR(255) not null,
  PRIMARY KEY  (CODE)
) ;

-- -------------------------------------
create table BRAND
(
  CODE        VARCHAR(20) not null,
  NAME        VARCHAR(128) not null,
  DESCRIPTION VARCHAR(255) not null,
  PRIMARY KEY  (CODE)
) ;

-- -------------------------------------

create table PRODUCT
(
  CODE        VARCHAR(20) not null,
  IMAGE_URL   VARCHAR(255) not null,
  NAME        VARCHAR(255) not null,
  DESCRIPTION VARCHAR(255) not null,
--  PRICE       DOUBLE precision not null,
  CREATE_DATE DATETIME not null DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY  (CODE)
) ;

-- -------------------------------------
create table PRICE (
    PRODUCT_CODE   VARCHAR(20) not null,
    START_DATE     DATETIME not null,
    PRICE          DOUBLE precision not null,
    PRIMARY KEY  (PRODUCT_CODE, START_DATE),
    index (PRODUCT_CODE),
    foreign key (PRODUCT_CODE)
        references PRODUCT(CODE)
);

-- -------------------------------------
create table PRODUCT_CATEGORY (
    PRODUCT_CODE   VARCHAR(20) not null,
    CATEGORY_CODE   VARCHAR(20) not null,

    PRIMARY KEY  (PRODUCT_CODE, CATEGORY_CODE),

    index (PRODUCT_CODE),
    foreign key (PRODUCT_CODE)
        references PRODUCT(CODE),
    index (CATEGORY_CODE),
    foreign key (CATEGORY_CODE)
        references CATEGORY(CODE)

);

-- -------------------------------------

create table PRODUCT_BRAND (
    PRODUCT_CODE   VARCHAR(20) not null,
    BRAND_CODE   VARCHAR(20) not null,

    PRIMARY KEY  (PRODUCT_CODE, BRAND_CODE),
    index (PRODUCT_CODE),
    foreign key (PRODUCT_CODE)
        references PRODUCT(CODE),
    index (BRAND_CODE),
    foreign key (BRAND_CODE)
        references BRAND(CODE)
);

-- -------------------------------------

create table PRODUCT_COLOR (
    PRODUCT_CODE   VARCHAR(20) not null,
    COLOR_CODE   VARCHAR(20) not null,
    PRIMARY KEY  (PRODUCT_CODE, COLOR_CODE),
    index (PRODUCT_CODE),
    foreign key (PRODUCT_CODE)
        references PRODUCT(CODE),
    index (COLOR_CODE),
    foreign key (COLOR_CODE)
        references COLOR(CODE)
);
-- -------------------------------------

-- Create table
create table SALES_ORDER
(
    ID               VARCHAR(36) not null,
    DESCRIPTION      VARCHAR(255),
    CREATED_BY       VARCHAR(20) not null,
    AMOUNT           DOUBLE precision not null,
    CUSTOMER_ADDRESS VARCHAR(255) not null,
    CUSTOMER_EMAIL   VARCHAR(128) not null,
    CUSTOMER_NAME    VARCHAR(255) not null,
    CUSTOMER_PHONE   VARCHAR(128) not null,
    ORDER_DATE       DATETIME not null DEFAULT CURRENT_TIMESTAMP,
    ORDER_NUM        INTEGER not null,

    primary key  (ID),

    index (ORDER_NUM),
    index (ID),
    index (CREATED_BY),
    foreign key (CREATED_BY)
        references ACCOUNT(USER_NAME)
) ;

-- Create table
create table ORDER_DETAIL
(
    ID         VARCHAR(36) not null,
    AMOUNT     DOUBLE precision not null,
    PRICE      DOUBLE precision not null,
    QUANTITY   DOUBLE not null,
    ORDER_ID   VARCHAR(50) not null,
    PRODUCT_CODE VARCHAR(20) not null,
    primary key  (ID),

    index (ORDER_ID),
    foreign key (ORDER_ID)
        references SALES_ORDER(ID),
    index (PRODUCT_CODE),
    foreign key (PRODUCT_CODE)
        references PRODUCT(CODE)
) ;

-- Create sample data
insert into ACCOUNT (USER_NAME, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE)
values ('employee1', 1,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_EMPLOYEE');

insert into ACCOUNT (USER_NAME, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE)
values ('manager1', 1,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_MANAGER');

-- --------------
insert into PRODUCT (CODE, NAME, DESCRIPTION, IMAGE_URL, CREATE_DATE)
values ('S001', 'Core Java', 'ebook ' , './img/products/S001.png', CURRENT_TIMESTAMP() );

insert into PRODUCT (CODE, NAME, DESCRIPTION, IMAGE_URL, CREATE_DATE)
values ('S002', 'Spring for Beginners', 'ebook ' , './img/products/S002.png', CURRENT_TIMESTAMP() );

insert into PRODUCT (CODE, NAME, DESCRIPTION, IMAGE_URL, CREATE_DATE)
values ('S003', 'Swift for Beginners', 'ebook ' , './img/products/S003.png', CURRENT_TIMESTAMP() );

insert into PRODUCT (CODE, NAME, DESCRIPTION, IMAGE_URL, CREATE_DATE)
values ('S004', 'Oracle XML Parser', 'ebook ' , './img/products/S004.png', CURRENT_TIMESTAMP() );

insert into PRODUCT (CODE, NAME, DESCRIPTION, IMAGE_URL, CREATE_DATE)
values ('S005', 'CSharp Tutorial for Beginers', 'ebook ' , './img/products/S005.png', CURRENT_TIMESTAMP() );

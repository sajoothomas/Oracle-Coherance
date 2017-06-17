DROP TABLE Customer;
DROP TABLE Orders;
DROP TABLE Line;
DROP TABLE Item;
DROP TABLE SEQUENCE;



CREATE TABLE Customer (
    id INTEGER NOT NULL, 
    name VARCHAR(255), 
    street VARCHAR(255), 
    city VARCHAR(255), 
    state VARCHAR(255), 
    zip VARCHAR(255), 
    PRIMARY KEY (id)
    );


CREATE TABLE Orders (
    id INTEGER NOT NULL, 
    customer_id INTEGER, 
    orderdate DATE, 
    ordertotal FLOAT, 
    PRIMARY KEY (id)
    );

CREATE TABLE Line  (
    id INTEGER NOT NULL, 
    order_id INTEGER,
    item_id INTEGER, 
    count INTEGER,
    eachprice FLOAT, 
    PRIMARY KEY (id)
    );

CREATE TABLE Item  (
    id INTEGER NOT NULL, 
    description VARCHAR(255),
    sku VARCHAR(20), 
    PRIMARY KEY (id)
    );



CREATE TABLE SEQUENCE (
    SEQ_NAME VARCHAR(255) NOT NULL, 
    SEQ_COUNT NUMBER, 
    PRIMARY KEY (SEQ_NAME)
    );

insert into SEQUENCE ("SEQ_NAME","SEQ_COUNT") values ('CUSTOMER_SEQ',50);
insert into SEQUENCE ("SEQ_NAME","SEQ_COUNT") values ('ORDER_SEQ',50);
insert into SEQUENCE ("SEQ_NAME","SEQ_COUNT") values ('LINE_SEQ',50);
insert into SEQUENCE ("SEQ_NAME","SEQ_COUNT") values ('ITEM',50);

exit;

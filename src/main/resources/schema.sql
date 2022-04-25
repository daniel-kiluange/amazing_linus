create table product (id integer not null, code varchar(255) not null, name varchar(255) not null, price bigint, primary key (id));
create table product_promotion (id integer not null, code varchar(255) not null, product_id integer, promotion_id integer, primary key (id));
create table promotion (id integer not null ,code varchar(255) not null, amount integer, free_quantity integer, price bigint, required_quantity integer, type varchar (100), primary key (id));
create sequence hibernate_sequence start with 1 increment by 1;
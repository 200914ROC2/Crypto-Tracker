drop table users_currencies;
drop table currencies;
drop table users;

CREATE TABLE IF NOT EXISTS users(
username varchar(30) PRIMARY KEY,
email varchar(30) NOT NULL,
hashed_password varchar(100) NOT null
);

CREATE TABLE IF NOT EXISTS currencies(
record_id serial primary key,
currency varchar(10) unique not null);

create table if not exists users_currencies(
username varchar(30) references users(username),
currency varchar(10) not null references currencies(currency));

insert into users (username,email,hashed_password) values ('becca','becca@email.com','password');
insert into users (username,email,hashed_password) values ('tyrone','tyrone@email.com','password');
insert into users (username,email,hashed_password) values ('ryan','ryan@email.com','password');
insert into users (username,email,hashed_password) values ('eric','eric@email.com','password');

insert into currencies (record_id, currency) values (default, 'BTC'); 
insert into users_currencies (username, currency) values ('becca','BTC');

insert into currencies (record_id, currency) values (default, 'AAC'); 
insert into users_currencies (username, currency) values ('becca','AAC');

insert into currencies (record_id, currency) values (default, 'ABCC'); 
insert into users_currencies (username, currency) values ('becca','ABCC');

insert into currencies (record_id, currency) values (default, 'ADB'); 
insert into users_currencies (username, currency) values ('tyrone','ADB');

insert into currencies (record_id, currency) values (default, 'AEN'); 
insert into users_currencies (username, currency) values ('tyrone','AEN');

insert into currencies (record_id, currency) values (default, 'AERGO'); 
insert into users_currencies (username, currency) values ('tyrone','AERGO');

insert into users_currencies (username, currency) values ('ryan','AERGO');

insert into users_currencies (username, currency) values ('tyrone','AAC');

insert into users_currencies (username, currency) values ('ryan','BTC');

insert into users_currencies (username, currency) values ('eric','BTC');

insert into users_currencies (username, currency) values ('eric','AAC');

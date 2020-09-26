drop table users;

CREATE TABLE IF NOT EXISTS users(
username varchar(30) PRIMARY KEY,
email text NOT NULL,
hashed_password text NOT null
);

drop table currencies;


CREATE TABLE IF NOT EXISTS currencies(
record_id serial primary key,
currency text unique not null);


drop table users_currencies;

create table if not exists users_currencies(
username varchar(30) references users(username),
currency text not null references currencies(currency));

<--setting up dummy data-->
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

insert into currencies (record_id, currency) values (default, 'AERGO'); 
insert into users_currencies (username, currency) values ('ryan','AERGO');

insert into currencies (record_id, currency) values (default, 'AAC'); 
insert into users_currencies (username, currency) values ('tyrone','AAC');

insert into currencies (record_id, currency) values (default, 'BTC'); 
insert into users_currencies (username, currency) values ('ryan','BTC');

insert into currencies (record_id, currency) values (default, 'BTC'); 
insert into users_currencies (username, currency) values ('eric','BTC');

insert into currencies (record_id, currency) values (default, 'AAC'); 
insert into users_currencies (username, currency) values ('eric','AAC');

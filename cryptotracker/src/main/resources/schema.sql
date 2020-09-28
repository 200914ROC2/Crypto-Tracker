drop table portfolio;
drop table users;

CREATE TABLE IF NOT EXISTS users(
user_id serial primary key,
username varchar(30) unique not null,
email varchar(30) NOT NULL,
hashed_password varchar(100) NOT null
);

CREATE TABLE IF NOT EXISTS portfolio(
record_id serial primary key,
username varchar(30) references users(username),
currency varchar(10) not null,
unique (username, currency)
);

insert into users (username,email,hashed_password) values ('becca','becca@email.com','password');
insert into users (username,email,hashed_password) values ('tyrone','tyrone@email.com','password');
insert into users (username,email,hashed_password) values ('ryan','ryan@email.com','password');
insert into users (username,email,hashed_password) values ('eric','eric@email.com','password');

insert into portfolio (username, currency) values ('becca','BTC');
insert into portfolio (username, currency) values ('becca','AAC');
insert into portfolio (username, currency) values ('becca','ABCC');

insert into portfolio (username, currency) values ('tyrone','AEN');
insert into portfolio (username, currency) values ('tyrone','AERGO');
insert into portfolio (username, currency) values ('tyrone','AAC');
insert into portfolio (username, currency) values ('tyrone','ADB');

insert into portfolio (username, currency) values ('ryan','AERGO');
insert into portfolio (username, currency) values ('ryan','BTC');

insert into portfolio (username, currency) values ('eric','BTC');
insert into portfolio (username, currency) values ('eric','AAC');

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
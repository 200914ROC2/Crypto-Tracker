select * from users;
select * from portfolio ;


insert into users (username,email,hashed_password) values ('?','?','?');

select email, hashed_password from users where username = '?'; 

insert into portfolio (record_id, username, currency) values (default, '?','?');

select currency from portfolio where username = '?';

select p.currency from users u  
join portfolio p on (u.username = p.username)
where u.username = '?' and u.hashed_password = '?';

select p.currency from users u  
join portfolio p on (u.username = p.username)
where u.username = 'becca' and u.hashed_password = 'password';


select * from users;
select * from currencies c ;
select * from users_currencies uc ;

insert into users (username,email,hashed_password) values ('?','?','?');


select email, hashed_password from users where username = '?'; 

insert into currencies (record_id, currency) values (default, '?'); 
insert into users_currencies (username, currency) values ('?','?');

select currency from users_currencies where username = '?';

select c.currency from users u  
join users_currencies uc on (u.username = uc.username)
join currencies c on (uc.currency = c.currency)
where u.username = '?' and u.hashed_password = '?';


select c.currency, u.username from users u  
join users_currencies uc on (u.username = uc.username)
join currencies c on (uc.currency = c.currency)
where u.username = '?' and u.hashed_password = '?';

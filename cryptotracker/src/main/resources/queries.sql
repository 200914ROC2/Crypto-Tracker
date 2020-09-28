select * from users;
select * from portfolio ;


insert into users (username,email,hashed_password) values ('?','?','?');

select email, hashed_password from users where username = '?'; 


select currency from portfolio where username = '?';

select u.user_id, u.username , u.email , u.hashed_password from users u
where u.username = '?' and u.hashed_password = '?';


update users set email = 'orange@gmail.com',
hashed_password = 'newPass'
where username = 'becca' and hashed_password = 'password';

insert into portfolio (record_id, username, currency) values (default, '?','?');

select u.user_id, u.username , u.email , u.hashed_password from users u
where u.username = 'tyrone' and u.hashed_password = 'password';



select u.user_id, u.username , u.email , u.hashed_password, p.currency from users u  
join portfolio p on (u.username = p.username);


select u.user_id, u.username , u.email , u.hashed_password, p.currency from users u  
join portfolio p on (u.username = p.username)
where u.username = '?' and u.hashed_password = '?';

select u.user_id, u.username , u.email , u.hashed_password, p.currency from users u  
join portfolio p on (u.username = p.username)
where u.username = 'tyrone' and u.hashed_password = 'password';


select p.currency from users u  
join portfolio p on (u.username = p.username)
where u.username = 'tyrone' and u.hashed_password = 'password';


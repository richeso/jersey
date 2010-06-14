set userid=root;
set passwd=password;
--connect MySQL.//localhost:3306/electricity;
--create database jersey;
--commit;
-- Table for Example Scramble App
   connect mysql.//localhost:3306/jersey;
   commit;
drop table word;
commit;
create table word  (
    id bigint not null auto_increment,
    value varchar(150) not null,
    points int not null,
    primary key (id)
);
insert into word (value, points) values ('simple',   20);
insert into word (value, points) values ('compound', 30);
insert into word (value, points) values ('password', 50);
insert into word (value, points) values ('notwithstanding', 90);
commit;
select * from word;
commit;

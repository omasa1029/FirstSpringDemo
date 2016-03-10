create database user;
use user;

--drop table usermaster;
create table usermaster (
    id int not null auto_increment,
    name varchar(50) not null,
    constraint P_UserMaster primary key(id)
);

insert into usermaster values(1, 'Tanaka Naoto');
insert into usermaster values(2, 'Satou Shigeki');
insert into usermaster values(3, 'Fukuda Shuhei');

select * from user.usermaster;


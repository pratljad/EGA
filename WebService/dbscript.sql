drop database ega;
create database ega;
use ega;

create table Calendar(
	id int not null,
    userid int,
    foreign key(userid) references EGAUser(id),
    primary key(id));

create table EGAUser(
	id int not null,
    email varchar(100),
    primary key(id));
    
create table Event(
	id int not null,
    calendarid int,
    importance int,
    urgency int,
    description varchar(200),
    title varchar(40),
    foreign key(calendarid) references Calendar(id));
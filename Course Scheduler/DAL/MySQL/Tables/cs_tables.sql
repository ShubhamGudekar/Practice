-- creating a new database named coursescheduler
create database coursescheduler;

-- using database coursescheduler
use coursescheduler;

-- creating student table
create table student(
sid int primary key,
sname varchar(20),
saddress varchar(50),
mobile int,
semail varchar(25),
dob date,
squalification varchar(20)
);

-- creating trainer table
create table trainer(
tid int primary key,
tname varchar(25),
tqualification varchar(20),
expertise varchar(20),
temail varchar(20),
tdob date,
tmobile_no double);

-- creating course table with foreign key from trainer table
create table course(
cid int primary key,
tid int,
cname varchar(20) not null,
duration int not null,
description varchar(50),
constraint fk_tid foreign key(tid) references trainer(tid)
on delete cascade
on update cascade
);


-- creating batch table with foreign key from course table
Create table batch(
bid int primary key,
cid int,
bname varchar(20),
startDate date,
endDate date,
status varchar(10),
timing int,
constraint fk_cid foreign key(cid) references course(cid)
on delete cascade
on update cascade
);


-- creating relation table between student and course
create table relation(
sid int,
cid int,
constraint pk primary key(sid,cid),
constraint fk_sid_rel foreign key(sid) references student(sid)
on delete cascade
on update cascade,
constraint fk_cid_rel foreign key(cid) references course(cid)
on delete cascade
on update cascade
);


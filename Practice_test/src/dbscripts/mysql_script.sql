-- creating a new database named coursescheduler
create database coursescheduler;

-- using database coursescheduler
use coursescheduler;

-- creating student table
create table student(
sid int primary key auto_increment,
sname varchar(20),
saddress varchar(50),
mobile int,
semail varchar(25) unique not null,
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
on update cascade,
constraint fk_cid_rel foreign key(cid) references course(cid)
on update cascade
);


-- Students
insert into student values(default,"Rishal","Pune",123456789,"rishal@gamil.com","1995-12-12","BE Electrical");
insert into student values(default,"Shikha","Mumbai",234567891,"shikha@gamil.com","1996-06-21","BE Mechanical");
insert into student values(default,"Sujit","Ratnagiri",345678912,"sujit@gamil.com","1994-11-11","BE Civil");
insert into student values(default,"Sakshi","Indore",456789123,"sakshi@gamil.com","1997-10-10","B.Tech Electronics");
insert into student values(default,"Abhishek","Delhi",567891234,"abhishek@gamil.com","1995-06-24","MBA in Fin");
insert into student values(default,"Mohak","Kolkata",678912345,"mohak@gamil.com","1999-08-08","BE EXTC");
insert into student values(default,"Atharav","Chennai",789123456,"atharav@gamil.com","1998-04-14","BE Mechanical");
insert into student values(default,"Rohit","Goa",891234567,"rohit@gamil.com","1997-06-11","BE Mechanical");
insert into student values(default,"Shubhangi","Solapur",912345678,"shubhangi@gamil.com","1996-01-19","MBA in Fin");
insert into student values(default,"Shubham","Chiplun",234891123,"shubham@gamil.com","1995-02-21","BE Electrical");



-- Trainer
insert into trainer values(101,"Vaishali Chikhalkar","MCS","Core Java","vaishali1@gmail.com","1990-04-05",9841253241);
insert into trainer values(102,"Kishori Khadilkar","MCS","DBT","Kishorik2@gmail.com","1974-08-03",9714523668);
insert into trainer values(103,"Vishal Jagtap","BE(Computer)","DSA","vishal42@gmail.com","1990-12-07",9654785234);
insert into trainer values(104,"Ravi Tambade","BE(Computer)",".NET Tech","ravitd4@gmail.com","1973-04-01","9514236789");
insert into trainer values(105,"Madhura Anturkar","BE(Computer)","Advance Java","madhura54@gmail.com","1978-09-02",9425635897);



-- Course
insert into course values(1,101,"COP",72,"Java & Operating system");
insert into course values(2,102,"Database Technology",84,"MySql & MongoDB");
insert into course values(3,105,"Core Java",108,"OOPS using Java");
insert into course values(4,103,"DSA",84,"Data Structure & algorithms using Java");
insert into course values(5,102,"WPT",108,"MERN Stack");
insert into course values(6,104,"SDM",72,"Software Development Life cycle");
insert into course values(7,104,"Dot Net",84,"C#");
insert into course values(8,105,"Advance Java",104,"JDBC & Servlet");

-- Batch
insert into batch values(101,2 ,"Batch1","2022-03-05","2022-09-05","Inprogress", 2 );
insert into batch values(102,1 ,"Batch2","2022-03-05","2022-09-05","Inprogress", 3);
insert into batch values(103,3 ,"Batch3","2022-03-05","2022-09-05","Inprogress", 4);


-- Relation
insert into relation values(1,2);
insert into relation values(2,1);
insert into relation values(3,2);
insert into relation values(4,4);
insert into relation values(5,5);
insert into relation values(6,6);
insert into relation values(7,1);
insert into relation values(8,2);
insert into relation values(9,4);
insert into relation values(10,2);


-- creating a student view to get all data related to student
create view studentview AS
select s.sid 'StudentID',s.sname'StudentName',c.cname'CourseName',b.bname'BatchName',b.startDate 'StartDate',b.endDate 'EndDate',b.status 'Status',c.duration 'Duration',b.timing 'Timing',t.tname 'Trainer'
from student s,course c,relation r,batch b,trainer t
where s.sid=r.sid and r.cid=c.cid and c.cid=b.cid and t.tid=c.tid;

-- creating a trainer view to get all data related to trainer
create view trainerview AS
select t.tid 'TrainerID',t.tname'TrainerName',c.cname'CourseName',b.bname'BatchName',b.startDate 'StartDate',b.endDate 'EndDate',b.status 'Status',c.duration 'Duration',b.timing 'Timing'
from course c,batch b,trainer t
where t.tid=c.tid and c.cid=b.cid;


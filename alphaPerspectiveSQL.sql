create database if NOT EXISTS alpha;
use alpha;

create table if NOT EXISTS  EMPLOYEE2 (
ID int primary key auto_increment,
CHIEF_ID int check (CHIEF_ID <= 20),
SALARY numeric(8,2)
);

create table if NOT EXISTS EMPLOYEE (
ID int primary key auto_increment,
DEPARTMENT_ID int,
CHIEF_ID int check (CHIEF_ID <= 20),
Name varchar(100) ,
POSITION varchar(100),
foreign key (CHIEF_ID) references EMPLOYEE2(ID)
);

SELECT DISTINCT NAME,POSITION FROM EMPLOYEE WHERE DEPARTMENT_ID=1;
SELECT  EMPLOYEE.NAME FROM EMPLOYEE inner join EMPLOYEE2 ON EMPLOYEE.ID=EMPLOYEE2.ID  where EMPLOYEE2.SALARY>= 2*(SELECT AVG(SALARY) from EMPLOYEE2 where EMPLOYEE2.CHIEF_ID=EMPLOYEE.ID) ;

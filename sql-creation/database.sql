--Create Database <databasename>


Create Table TFood
(
nProductId int IDENTITY Primary key,
cName varchar(255) not null,
cDescription varchar(2048),
nUnitPrice money not null,
nStock int not null,
dExpirationDate date not null
)

Create Table TNonFood
(
nProductId int IDENTITY Primary key,
cName varchar(255) not null,
cDescription varchar(2048),
nUnitPrice money not null,
nStock int not null
)


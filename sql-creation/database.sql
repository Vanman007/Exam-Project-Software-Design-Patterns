--Create Database <databasename>


Create Table TProduct
(
nProductId int IDENTITY Primary key,
cName varchar(255) not null,
cDescription varchar(2048),
nUnitPrice money not null,
nStock int not null,
)


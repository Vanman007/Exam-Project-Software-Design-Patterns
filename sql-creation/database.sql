--Create Database <databasename>


Create Table TElectronicsProduct
(
nProductId int IDENTITY Primary key,
cType varchar(255) not null,
cName varchar(255) not null,
cDescription varchar(2048) not null,
nUnitPrice money not null,
nStock int not null
)




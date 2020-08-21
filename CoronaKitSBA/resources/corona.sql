DROP DATABASE coronakitDb;
CREATE DATABASE coronakitDb;

use coronakitDb;

CREATE Table products(

pid INT PRIMARY KEY,
pname varchar(20) NOT NULL,
pcost DECIMAL(5,2) NOT NULL,
pdesc varchar(100)
);


INSERT INTO products(pid,pname,pcost,pdesc) values 
(1, "Facemasks",20.0,"Protective face masks"),
(2, "Sanitizers",100.00,"Hand Sanitizers"),
(3, "Vitamin C",30.02,"Tablets");



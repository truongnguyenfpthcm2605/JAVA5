CREATE DATABASE J5SHOP

ON
(
	NAME = J5SHOP_dat,
	FILENAME = 'D:\JAVA5\SQL\J5SHOP.mdf'

)
LOG ON
(
	NAME = J5SHOP_ldf,
	FILENAME = 'D:\JAVA5\SQL\J5SHOP.ldf'
)
GO

USE J5SHOP

create table accounts(
	username nvarchar(50) primary key,
	password nvarchar(50) not null,
	fullname  nvarchar(50) not null,
	email  nvarchar(50) not null,
	photo  nvarchar(50)  null,
	active bit default 1,
	admin bit default 0
)
go

create table categories(
	id char(4) primary key,
	name  nvarchar(50) not null,
)
go
create table  products (
	id int identity(1,1) primary key,
	name  nvarchar(50) not null,
	image  nvarchar(50) not null,
	price float not null,
	createdate date default getdate(),
	active bit default 1,
	categoryid char(4) 
	FOREIGN KEY (categoryid) REFERENCES categories(id)


)
go

create table orders(
	id bigint identity(1,1) primary key,
	username  nvarchar(50) not null,
	createdate date default getdate(),
	address  nvarchar(50) not null
	FOREIGN KEY (username) REFERENCES accounts(username),
)
go
create table orderdetails(
	id bigint identity(1,1) primary key,
	orderid bigint ,
	productid int,
	price float not null,
	quanity int not null,
	FOREIGN KEY (orderid) REFERENCES orders(id),
	FOREIGN KEY (productid) REFERENCES products(id)

)
insert into accounts values(N'truong123',N'truong123',N'Nguyễn Văn Trường',N'truong123@gmail.com',null,1,1)

insert into accounts(username,password,fullname,email) values(N'hau123',N'hau123',N'Võ Văn Hậu',N'Hau@gmail.com')
select * from accounts

insert into categories values
	('1',N'Apple'),
	('2',N'Samsung'),
	('3',N'Htc'),
	('4',N'LG'),
	('5',N'Xiaomi'),
	('6',N'Oppo'),
	('7',N'Realme')

	select * from categories


	insert into products(name,price,image,categoryid) values
	(N'Iphone 11 Pro Max',203402,N'i.jpg',1),
	(N'Iphone 12 Pro Max',203402,N'i.jpg',1),
	(N'Iphone 14 Pro Max',2002,N'i.jpg',1),
	(N'Iphone 13 Pro Max',2402,N'i.jpg',1),
	(N'Iphone 13 Pro ',202,N'i.jpg',1),
	(N'Iphone 11 Pro ',2032402,N'i.jpg',1),
	(N'Iphone 14 Pro ',202202,N'i.jpg',1),
	(N'Samsung 12 Pro ',13402,N'i.jpg',2),
	(N'Samsung 12 Pro ',99003402,N'i.jpg',2),
	(N'Samsung 12 Pro ',5043402,N'i.jpg',2),
	(N'Samsung 12 Pro ',2003402,N'i.jpg',2),
	(N'Samsung 12 Pro ',2403402,N'i.jpg',2),
	(N'Samsung 12 Pro ',23003402,N'i.jpg',2),
	(N'Samsung 12 Pro ',203402,N'i.jpg',2),
	(N'Samsung 12 Pro ',203402,N'i.jpg',2),
	(N'OPPO 12 Pro ',201402,N'i.jpg',6),
	(N'OPPO 12 Pro ',443402,N'i.jpg',6),
	(N'OPPO 12 Pro ',7703402,N'i.jpg',6),
	(N'OPPO 12 Pro ',2003402,N'i.jpg',6),
	(N'OPPO 12 Pro ',003402,N'i.jpg',6),
	(N'OPPO 12 Pro ',2003402,N'i.jpg',6),
	(N'OPPO 12 Pro ',2001202,N'i.jpg',6),
	(N'OPPO 12 Pro ',20102,N'i.jpg',6),
	(N'OPPO 12 Pro ',213402,N'i.jpg',6),
	(N'OPPO 12 Pro ',103402,N'i.jpg',6),
	(N'OPPO 12 Pro ',903402,N'i.jpg',6)
	
	select * from products

	SELECT * FROM products o WHERE o.name LIKE N'Iphone%'



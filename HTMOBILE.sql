CREATE DATABASE HTMOBILE

ON
(
	NAME = ActionMovie_dat,
	FILENAME = 'D:\JAVA5\SQL\HTMOBILE.mdf'

)
LOG ON
(
	NAME = ActionMovie_ldf,
	FILENAME = 'D:\JAVA5\SQL\HTMOBILE.ldf'
)
GO
USE HTMOBILE
GO
CREATE TABLE [users] (
  [id] int identity(1,1) PRIMARY KEY,
  [password] nvarchar(256) not null,
  [fullname] nvarchar(30) not null,
  [email] nvarchar(50) not null,
  [gender] bit default 1,
  [birthday] date not null,
  [active] bit default 1,
  [createday] datetime default getdate(),
  [updateday] datetime null,
  [img] nvarchar(100) null,
  [role] bit default 0
)
GO

CREATE TABLE [category] (
  [id] int identity(1,1) PRIMARY KEY,
  [imgcategory] nvarchar(100) null,
  [title] nvarchar(100) not null
)
GO

CREATE TABLE [voucher] (
  [id] nvarchar(6) PRIMARY KEY,
  [name] nvarchar(100) not null,
  [discount] int not null,
  [createday] datetime default getdate(),
  [endday] datetime not null,
  [active] bit default 1
)
GO

CREATE TABLE [product] (
  [id] int identity(1,1) PRIMARY KEY,
  [title] nvarchar(100) not null,
  [pricecost] float not null,
  [price] float not null,
  [ram] int not null,
  [rom] int not null,
  [pin] int not null,
  [chip] nvarchar(30)  not null,
  [camera] int not null,
  [screen] float not null,
  [createday] datetime default getdate(),
  [updateday] datetime null ,
  [quanityfinal] int not null,
  [quantitysold] int  not null,
  [imgproduct] nvarchar(50)  not null,
  [thumnail] nvarchar(256)  not null,
  [description] nvarchar(max)  not null,
  [active] bit  default 1,
  [views] bigint default 0 ,
  [categoryid] int not null,
)
GO

CREATE TABLE [orders] (
  [id] int identity(1,1) PRIMARY KEY,
  [address] nvarchar(300) not null,
  [phone] varchar(12) not null,
  [status] nvarchar(100) not null,
  [createday] datetime default getdate() ,
  [notes] nvarchar(300) null,
  [voucher] nvarchar(60) null,
  [usersid] int not null
)	
GO

CREATE TABLE [ordersDetail] (
[id] int identity(1,1) PRIMARY KEY,
  [ordersid] int,
  [productid] int,
  [price] float not null,
  [quantity] int not null
  
)
GO

CREATE TABLE [favorite] (
  [id] int identity(1,1) PRIMARY KEY,
  [userid] int not null,
  [productid] int not null,
  [createday] datetime  default getdate(),
  [active] bit default 1
)
GO

CREATE TABLE [post] (
  [id] int identity(1,1) PRIMARY KEY,
  [createday] datetime default getdate(),
  [img] nvarchar(250) not null,
  [description] nvarchar(max) not null
)
GO

CREATE TABLE [feedback] (
  [id] int identity(1,1) PRIMARY KEY,
  [userid] int not null,
  [description] nvarchar(300) not null,
  [createday] datetime default getdate()
)
GO

CREATE TABLE [share] (
  [id] int identity(1,1) PRIMARY KEY,
  [userid] int not null,
  [productid] int not null,
  [number] int not null,
  [createday] datetime default getdate()
)
GO


alter table[feedback] add  reply bit

ALTER TABLE [product] ADD FOREIGN KEY ([categoryid]) REFERENCES [category] ([id])
GO

ALTER TABLE [orders] ADD FOREIGN KEY ([usersid]) REFERENCES [users] ([id])
GO


ALTER TABLE [feedback] ADD FOREIGN KEY ([userid]) REFERENCES [users] ([id])
GO

ALTER TABLE [ordersDetail] ADD FOREIGN KEY ([productid]) REFERENCES [product] ([id])
GO

ALTER TABLE [ordersDetail] ADD FOREIGN KEY ([ordersid]) REFERENCES [orders] ([id])
GO

ALTER TABLE [share] ADD FOREIGN KEY ([productid]) REFERENCES [product] ([id])
GO

ALTER TABLE [share] ADD FOREIGN KEY ([userid]) REFERENCES [users] ([id])
GO

ALTER TABLE [favorite] ADD FOREIGN KEY ([userid]) REFERENCES [users] ([id])
GO

ALTER TABLE [favorite] ADD FOREIGN KEY ([productid]) REFERENCES [product] ([id])
GO

ALTER TABLE [ordersDetail] ADD FOREIGN KEY ([ordersid]) REFERENCES [orders] ([id])
GO

ALTER TABLE [ordersDetail] ADD FOREIGN KEY ([productid]) REFERENCES [product] ([id])
GO

select * from accounts


drop database thetradenetworktest;
go
create database TheTradeNetworkTest;
go
use TheTradeNetworkTest;

CREATE TABLE category
(
	categoryID		INT				PRIMARY KEY IDENTITY,
	categoryName	VARCHAR(50)		NOT NULL
)
go

CREATE TABLE person
(
	username		VARCHAR(50)		NOT NULL		PRIMARY KEY		CHECK(len(username) >= 5 and len(username) <= 30),
	password		VARCHAR(50)		NOT NULL		CHECK(len(password) >= 5 and len(password) <= 30),	
	zipcode			VARCHAR(5)		NOT NULL		CHECK(len(zipcode) = 5),		
	state			VARCHAR(50)		NOT NULL,
	phone			VARCHAR(10)		NOT NULL		CHECK(len(phone) = 10),
	city			VARCHAR(50)		NOT NULL,
	street			VARCHAR(50)		NOT NULL
)
go

CREATE TABLE item
(
	item_id				INT				NOT NULL		PRIMARY KEY IDENTITY,
	itemname			VARCHAR(50)		NOT NULL,
	item_description	VARCHAR(100)	NOT NULL,
	categoryID			INT				NULL
		REFERENCES category(categoryID) ON DELETE SET NULL
										ON UPDATE NO ACTION,
	traderA			VARCHAR(50)		NOT NULL
		REFERENCES person(username)		ON DELETE CASCADE
										ON UPDATE NO ACTION
)
go

CREATE TABLE offer
(
	offer_id			INT				NOT NULL		PRIMARY KEY IDENTITY,
	date_of_offer		DATETIME		NOT NULL,
	acceptedYN			CHAR			NOT NULL		DEFAULT  'N',
	item_id				INT				NOT NULL
		REFERENCES item(item_id) ON DELETE CASCADE
								 ON UPDATE NO ACTION,
	traderB				VARCHAR(50)		NOT NULL
		REFERENCES person(username)		ON DELETE NO ACTION
										ON UPDATE NO ACTION
)
go

CREATE TABLE tradehistory
(
	item_id				INT				NOT NULL
		REFERENCES item(item_id) ON DELETE NO ACTION
								 ON UPDATE NO ACTION,
	offer_id			INT				NULL
		REFERENCES offer(offer_id)	ON DELETE NO ACTION
									ON UPDATE NO ACTION,
	date_accepted		DATETIME		NULL	
	
)
go

CREATE TABLE tradetable
(
	item_id				INT				NOT NULL
		REFERENCES item(item_id) ON DELETE CASCADE
								 ON UPDATE NO ACTION,
	offer_id			INT				NULL
		REFERENCES offer(offer_id)	ON DELETE NO ACTION
									ON UPDATE NO ACTION,
	offerYN				CHAR			NOT NULL		DEFAULT		'N'
	
)
go

--Insert category values--
insert into category(categoryname)
values('Cars'), ('Electronics'),('Books'),('Video Games'), ('Furniture'),('Toys'),('Misc');

--Insert two test users--
insert into person
values('Tester','tester','11111','Alabama','7708897788','test','test st'),('TesterBob','tester','11111','Alabama','7706677744','testcity','test blvd')
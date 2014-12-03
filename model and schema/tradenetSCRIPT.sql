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
go
--Insert two test users--
insert into person
values('Tester','tester','11111','Alabama','7708897788','test','test st'),('TesterBob','tester','11111','Alabama','7706677744','testcity','test blvd')
go
--TEST DATA--

--Marcus
insert into person
values('marcus','tester','11111','Georgia','7708897788','Statesboro','17 charleston st');

INSERT INTO ITEM(itemname, item_description, categoryID, traderA) VALUES
('Gamecube','A box of entertaining attributes',4,'marcus'),
('Stick','A rod of magical processes',7,'marcus'),
('A broken stick','TOO MUCH MAGIC',7,'marcus'),
('Wizards left sock','kinda crusty',7,'marcus');

insert into tradetable(item_id,offer_id) 
values(1, null),
(2, null), (3, null), (4, null);

insert into tradehistory 
values(1, null, null),
(2, null, null), (3, null, null), (4, null, null)

go

--Garrett
insert into person
values('garrett','tester','11111','Georgia','6675589923','Statesboro','54 Random rd');

INSERT INTO ITEM(itemname, item_description, categoryID, traderA) VALUES
('Table','smells of rich mahogony',5,'garrett'),
('Laptop','I dont understand',2,'garrett'),
('gokart','Comes with free bananas',7,'garrett'),
('Dragon eye','dont ask where i got this',7,'garrett');

insert into tradetable(item_id,offer_id) 
values(5, null),
(6, null), (7, null), (8, null);

insert into tradehistory 
values(5, null, null),
(6, null, null), (7, null, null), (8, null, null)

go

--Alex
insert into person
values('alexR','tester','11111','Georgia','4043397744','Statesboro','44 four blvd');

INSERT INTO ITEM(itemname, item_description, categoryID, traderA) VALUES
('Banana','Excelent for tripping people',6,'alexR'),
('Diamond','100% fake',2,'alexR'),
('Throwing axe','dont mind the red drippy stuff',7,'alexR'),
('Mysterious body sized bag','ummmm',7,'alexR');

insert into tradetable(item_id,offer_id) 
values(9, null),
(10, null), (11, null), (12, null);

insert into tradehistory 
values(9, null, null),
(10, null, null), (11, null, null), (12, null, null)

go

--Will
insert into person
values('willK','tester','11111','Alabama','8882234455','Steele','14 Fredrickson st');

INSERT INTO ITEM(itemname, item_description, categoryID, traderA) VALUES
('chair','not a chair',5,'willK'),
('dictionary','good for nothing really',3,'willK'),
('ancient key','May be used for magical box',7,'willK'),
('Magical box','may or may not contain treasure',7,'willK');

insert into tradetable(item_id,offer_id) 
values(13, null),
(14, null), (15, null), (16, null);

insert into tradehistory 
values(13, null, null),
(14, null, null), (15, null, null), (16, null, null)

go

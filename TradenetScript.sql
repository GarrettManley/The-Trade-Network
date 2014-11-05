CREATE DATABASE TheTradeNetwork
go

Use TheTradeNetwork
go


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
	traderA				VARCHAR(50)		NOT NULL
		REFERENCES person(username)		ON DELETE CASCADE
										ON UPDATE NO ACTION
)
go

CREATE TABLE offer
(
	offer_id			INT				NOT NULL		PRIMARY KEY IDENTITY,
	date_of_offer		DATETIME		NOT NULL,
	acceptedYN			CHAR			NOT NULL		DEFAULT  'N',
	traderB				VARCHAR(50)		NOT NULL		
		REFERENCES person(username) ON DELETE CASCADE
									ON UPDATE NO ACTION,
	item_id				INT				NOT NULL
		REFERENCES item(item_id) ON DELETE NO ACTION
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
									ON UPDATE NO ACTION
)
go

CREATE TABLE tradetable
(
	item_id				INT				NOT NULL
		REFERENCES item(item_id) ON DELETE CASCADE
								 ON UPDATE NO ACTION,
	offer_id			INT				NULL
		REFERENCES offer(offer_id)	ON DELETE NO ACTION
									ON UPDATE NO ACTION
)
go


INSERT INTO category
values('Cars'),('Electronics'),('Books'),('Video Games'),('Toys'),('Furniture'),('Misc')

go

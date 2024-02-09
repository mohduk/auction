

//create table for Bidder 

create table Bidder(bidder_id int PRIMARY KEY, bidder_name varchar(100) NOT NULL, email varchar(100) UNIQUE,
 phone_no  varchar(20),CONSTRAINT chk_bidder_phone CHECK(phone_no LIKE '___'________'), 
 CONSTRAINT chk_bidder_email CHECK(email LIKE '%@%.%'));



//create table for Seller

create table Seller(bidder_id int PRIMARY KEY, seller_name varchar(100) NOT NULL, email varchar(100) UNIQUE,
 phone_no  varchar(20),CONSTRAINT chk_seller_phone CHECK(phone_no LIKE '___'________'), 
 CONSTRAINT chk_seller_email CHECK(email LIKE '%@%.%'));
 
 
 
 //create table for Product
 
 create table Product(product_id int PRIMARY KEY, product_name varchar(200) NOT NULL, base_price DECIMAL(10, 2),
 seller_id int, CONSTRAINT fk_product_seller FOREIGN KEY(seller_id) REFERENCES Seller(seller_id));
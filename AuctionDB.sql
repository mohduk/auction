

//create table for bidder
CREATE TABLE Bidder (
    bidder_id INT PRIMARY KEY,
    bidder_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone_no VARCHAR(20),
    CONSTRAINT chk_bidder_phone CHECK (LENGTH(phone_no) = 10 AND phone_no NOT LIKE '%[^0-9]%'),
    CONSTRAINT chk_bidder_email CHECK (email LIKE '%@%' AND email LIKE '%.%')
);


// create table for Seller

CREATE TABLE Seller (
    seller_id INT PRIMARY KEY,
    seller_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone_no VARCHAR(20),
    CONSTRAINT chk_seller_phone CHECK (LENGTH(phone_no) = 10 AND phone_no NOT LIKE '%[^0-9]%'),
    CONSTRAINT chk_seller_email CHECK (email LIKE '%@%' AND email LIKE '%.%')
);


//create table for Product

CREATE TABLE Product (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(200) NOT NULL,
    base_price DECIMAL(10, 2),
    seller_id INT,
    CONSTRAINT fk_product_seller FOREIGN KEY (seller_id) REFERENCES Seller (seller_id)
);

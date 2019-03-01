CREATE TABLE acme.store (
  id             INT AUTO_INCREMENT PRIMARY KEY,
  name   		 VARCHAR(50)  NOT NULL,
  code			 VARCHAR(50),	 
  address        VARCHAR(50)  
);

CREATE TABLE acme.order_status (
	id			INT PRIMARY KEY,
	name		VARCHAR(50)
)

CREATE TABLE acme.order (
	id						INT AUTO_INCREMENT PRIMARY KEY,
	address					VARCHAR(50),
	confirmation_date 		date,
	id_order_status			INT,
	id_store				INT,
	FOREIGN KEY fk_order_order_status(id_order_status) references acme.order_status(id),
	FOREIGN KEY fk_order_store(id_store) references acme.store(id)
)

CREATE TABLE acme.order_item (
	id						INT AUTO_INCREMENT PRIMARY KEY,
	unitPrice				DECIMAL(10,2),
	quantity				INT,
	refunded 				BIT,
	id_order				INT,
	description 			VARCHAR(50),
	FOREIGN KEY fk_order_item_order_item_status(id_order_item_status) references acme.order_item_status (id),
	FOREIGN KEY fk_order_item_order(id_order) references acme.store (id)
)

CREATE TABLE acme.payment_status (
	id			INT PRIMARY KEY,
	name		VARCHAR(50)
)

CREATE TABLE acme.payment (
	id						INT AUTO_INCREMENT PRIMARY KEY,
	credit_card				VARCHAR(50),
	payment_date			DATETIME,
	id_payment_status		INT,
	FOREIGN KEY  fk_payment_payment_status (id_payment_status) references acme.payment (id)
)

insert into acme.payment_status values
(1, "PROCESSING"),
(2, "CONCLUDED"),
(3, "REFUSED"),
(4, "CANCELLED");

insert into acme.order_status values
(1, "OPEN"),
(2, "FINISHED"),
(3, "CANCELLED"),
(4, "REFUNDED");


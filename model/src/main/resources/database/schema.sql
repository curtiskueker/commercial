CREATE TABLE user (
id int primary key auto_increment,
login VARCHAR (50),
password VARCHAR (50),
first_name VARCHAR (50),
last_name VARCHAR (50),
email_address VARCHAR (256),
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE address (
id int primary key auto_increment,
user_id int,
address_line_1 VARCHAR (256),
address_line_2 VARCHAR (256),
city VARCHAR (50),
state VARCHAR (10),
postal_code VARCHAR (50),
country VARCHAR (50),
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp,
FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE access_user (
id int primary key auto_increment,
login VARCHAR (50),
password VARCHAR (50),
is_active boolean,
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE access_role (
id int primary key auto_increment,
name VARCHAR (50),
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE access_role_user (
access_user_id int,
access_role_id int,
FOREIGN KEY (access_user_id) REFERENCES access_user(id),
FOREIGN KEY (access_role_id) REFERENCES access_role(id)
);

CREATE TABLE access_action (
id int primary key auto_increment,
access_user_id int,
access_action_type VARCHAR (50),
id_value int,
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp,
FOREIGN KEY (access_user_id) REFERENCES access_user(id)
);

CREATE TABLE tracking (
id int primary key auto_increment,
name VARCHAR (256),
description text,
start_date DATE,
end_date DATE,
is_active boolean,
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE orders (
id int primary key auto_increment,
external_id int,
user_id int,
access_user_id int,
tracking_id int,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (access_user_id) REFERENCES access_user(id),
FOREIGN KEY (tracking_id) REFERENCES tracking(id)
);

CREATE TABLE manufacturer (
id int primary key auto_increment,
name VARCHAR (256),
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE item (
id int primary key auto_increment,
cat_number VARCHAR (50),
manufacturer_id int,
name VARCHAR (256),
description text,
price DECIMAL (10, 2),
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE order_item (
order_id int,
item_id int,
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (item_id) REFERENCES item(id)
);

CREATE TABLE product_category (
id int primary key auto_increment,
category_name VARCHAR (50),
category_description text,
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE item_product_category (
item_id int,
product_category_id int,
FOREIGN KEY (item_id) REFERENCES item(id),
FOREIGN KEY (product_category_id) REFERENCES product_category(id)
);

CREATE TABLE review (
id int primary key auto_increment,
user_id int,
item_id int,
rating int,
description text,
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (item_id) REFERENCES item(id)
);

CREATE TABLE gift_card (
id int primary key auto_increment,
claimcode VARCHAR (50),
amount DECIMAL (10, 2),
expired_date DATE,
is_active boolean,
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE order_gift_card (
order_id int,
gift_card_id int,
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (gift_card_id) REFERENCES gift_card(id)
);

CREATE TABLE order_status (
id int primary key auto_increment,
order_id int,
status VARCHAR (50),
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp,
FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE order_adjustment (
id int primary key auto_increment,
order_id int,
amount DECIMAL (10, 2),
adjustment_type VARCHAR (50),
description text,
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp,
FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE credit_card (
id int primary key auto_increment,
credit_card_type VARCHAR (50),
credit_card_number VARCHAR (50),
expiration_year int,
expiration_month int,
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp
);

CREATE TABLE payment (
id int primary key auto_increment,
payment_type VARCHAR (50),
order_id int,
credit_card_id int,
gift_card_id int,
amount DECIMAL (10, 2),
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp,
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (credit_card_id) REFERENCES credit_card(id),
FOREIGN KEY (gift_card_id) REFERENCES gift_card(id)
);

CREATE TABLE session (
id int primary key auto_increment,
cookie VARCHAR (50),
user_id int,
access_user_id int,
order_id int,
tracking_id int,
date_created timestamp default current_timestamp,
date_modifed timestamp default current_timestamp on update current_timestamp,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (access_user_id) REFERENCES access_user(id),
FOREIGN KEY (tracking_id) REFERENCES tracking(id)
);

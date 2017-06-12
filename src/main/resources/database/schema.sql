CREATE TABLE user (
id
login
password
first_name
last_name
email_address
date_created
date_modified

CREATE TABLE address (
id
user_id
address_line_1
address_line_2
city
state
postal_code
country
date_created
date_modified

CREATE TABLE access_user (
id
login
password
is_active
date_created
date_modified

CREATE TABLE access_role (
id
name
date_created
date_modified

CREATE TABLE access_role_user (
access_user_id
access_role_id
date_created

CREATE TABLE access_action (
id
access_user_id
access_action_type
id_value
date_created
date_modified

CREATE TABLE tracking (
id
name
description
start_date
end_date
is_active
date_created
date_modified

CREATE TABLE orders (
id
order_number
user_id
access_user_id
tracking_id

CREATE TABLE manufacturer (
id
name
date_created
date_modified

CREATE TABLE item (
id
cat_number
manufacturer_id
name
description
price
date_created
date_modified

CREATE TABLE order_item (
order_id
item_id
date_created

CREATE TABLE product_category (
id
category_name
category_description
date_created
date_modified

CREATE TABLE item_product_category (
item_id
product_category_id

CREATE TABLE review (
id
user_id
item_id
rating
description
date_created
date_modified

CREATE TABLE gift_card (
id
claimcode
amount
expired_date
is_active
date_created
date_modified

CREATE TABLE order_gift_card (
order_id
gift_card_id
date_created

CREATE TABLE order_status (
id
order_id
status
date_created
date_modified

CREATE TABLE order_adjustment (
id
order_id
amount
adjustment_type
description
date_created
date_modified

CREATE TABLE credit_card (
id
credit_card_type
credit_card_number
expiration_year
expiration_month
date_created
date_modified

CREATE TABLE payment (
id
payment_type
order_id
credit_card_id
gift_card_id
amount
date_created
date_modified

CREATE TABLE session (
id
cookie
user_id
access_user_id
order_id
tracking_id
date_created
date_modified

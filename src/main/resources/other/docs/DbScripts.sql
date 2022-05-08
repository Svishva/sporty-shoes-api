#SportyShoes Scripts


###################################################################


-- A)
#1
INSERT INTO sporty_shoes.users (user_id,name,`password`)
	VALUES ('user id','name','pass');

#2

#3
SELECT
	product_id,
	name,
	msrp,
	quantity_in_stock,
	product_vendor,
	create_time
FROM
	products;

#4
SELECT
	product_id,
	name,
	msrp,
	quantity_in_stock,
	product_vendor,
	create_time
FROM
	products p
WHERE
	name like "%name%";

#5
SELECT * FROM products p WHERE p.product_id = "###"; 

#6
SELECT
	user_id,
	name,
	`password`,
	create_time
FROM
	users u
WHERE
	u.user_id = "user id";

#7
INSERT
	INTO
	sporty_shoes.orders
(order_id,
	quantity,
	user_id,
	order_date,
	create_time,
	product_id)
VALUES('1',
1,
'user',
'2022-05-07 12:51:37',
'2022-05-07 12:51:37',
'123');

#8
SELECT
	order_id,
	quantity,
	user_id,
	order_date,
	create_time,
	product_id
FROM
	sporty_shoes.orders u
WHERE
	u.user_id = '1';

#9
UPDATE
	sporty_shoes.users
SET
	name = 'name2',
	password = 'pass2'
WHERE
	user_id = 'user id';



SELECT * FROM users u;
SELECT * FROM orders o ;

###################################################################
-- B)

#1

#2
UPDATE users SET `password` = "###" WHERE user_id = "###";

#3
SELECT user_id, name, `password`, create_time FROM users u;

#4
SELECT
	user_id,
	name,
	`password`,
	create_time
FROM
	users u
WHERE
	u.name like "%search_word%";

#5
SELECT user_id, name, `password`, create_time FROM users u WHERE u.user_id = "###";
SELECT user_id, name, `password`, create_time FROM users u WHERE u.name  = "###";


#6
SELECT * FROM products p ;
#7
INSERT INTO sporty_shoes.products (product_id, name, msrp, quantity_in_stock, product_vendor)
	VALUES ('asdkjad','name',25.23,2,'vend');
#8
SELECT * FROM products p WHERE p.product_id = "###";

#9
UPDATE products SET name = "###" WHERE product_id = "#";
UPDATE products SET msrp = "###" WHERE product_id = "#";
UPDATE products SET quantity_in_stock = "###" WHERE product_id = "#";
UPDATE
	products
SET
	product_vendor = "###"
WHERE
	product_id = "#";

#10
DELETE
FROM
	sporty_shoes.products
WHERE
	product_id = '#';

#11
SELECT
	order_id,
	quantity,
	user_id,
	order_date,
	create_time,
	product_id
FROM
	sporty_shoes.orders o
ORDER BY
	o.order_date ASC; 

select
	order_id,
	quantity,
	user_id,
	order_date,
	create_time,
	product_id
from
	sporty_shoes.orders o
order by
	o.order_date desc; 

SELECT
	order_id,
	quantity,
	user_id,
	order_date,
	create_time,
	product_id
FROM
	sporty_shoes.orders o ORDER BY o.order_id  ASC; 

SELECT
	order_id,
	quantity,
	user_id,
	order_date,
	create_time,
	product_id
FROM
	sporty_shoes.orders o
ORDER BY
	o.order_id DESC; 

#12
SELECT * FROM orders o WHERE product_id = "1";

#13
SELECT * FROM orders o WHERE o.user_id = "1";


###################################################################

SELECT name , `password`, true  FROM users WHERE user_id = "name2";
SELECT  * FROM users WHERE user_id = "user id";
SELECT  * FROM users;

SELECT * FROM user_roles ur  ;
SELECT user_id , `role`  FROM user_roles ur WHERE  user_id = "user id" ;
SELECT * FROM products p ;
desc



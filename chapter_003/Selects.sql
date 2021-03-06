SELECT p.id,
p.name,
p.expired_date,
p.price
FROM product as p
INNER JOIN type as t on p.type_id = t.id
WHERE t.name = 'СЫР';

SELECT p.id,
p.name,
p.expired_date,
p.price
FROM product as p
WHERE p.name LIKE '%мороженное%';

SELECT p.id,
p.name,
p.expired_date,
p.price
FROM product as p
WHERE date_trunc('month', p.expired_date) = date_trunc('month', now()+ interval '1 month');

SELECT p.id,
p.name,
p.expired_date,
p.price
FROM product as p
WHERE p.price = (SELECT MAX(product.price) from product);

SELECT COUNT(*)
FROM product as p
INNER JOIN type as t on p.type_id = t.id
WHERE t.name = 'СЫР';

SELECT p.id,
p.name,
p.expired_date,
p.price
FROM product as p
INNER JOIN type as t on p.type_id = t.id
WHERE t.name = 'СЫР' AND t.name = 'МОЛОКО';

SELECT Count(p.id) as c,
t.id,
t.name
FROM product as p
INNER JOIN type as t on p.type_id = t.id
WHERE c < 10;

SELECT *
FROM product as p
INNER JOIN type as t on p.type_id = t.id;
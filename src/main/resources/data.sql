TRUNCATE  product;
TRUNCATE discount_card;

INSERT INTO product
VALUES ( 1,'Bread', 1.5),
       (2, 'Loaf', 1.75),
       (3, 'Milk', 1.6),
       (4, 'Kefir', 1.5),
       (5, 'Cheese', 2.5),
       (6, 'Sausage', 3.0),
       (7, 'Butter', 2.2),
       (8, 'Oil', 2.4),
       (9, 'Potato', 3.0),
       (10, 'Pasta', 1.2),
       (11, 'Groats', 1.0),
       (12, 'Sweets', 2.5),
       (13, 'Chocolate', 1.7),
       (14, 'Chips', 2.3),
       (15, 'Cola', 2.3),
       (16, 'Pepsi', 2.0);
INSERT INTO discount_card
VALUES (1,1111, 5),
       (2,2222, 3),
       (3,3333, 4),
       (4,4444, 10),
       (5,5555, 7),
       (6,6666, 8),
       (7,7777, 9);

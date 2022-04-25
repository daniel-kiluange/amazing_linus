insert into product (id, code, name, price)
values (1, 'Dwt5F7KAhi', 'Amazing Pizza!', 1099),
       (2, 'PWWe3w1SDU', 'Amazing Burger!', 999),
       (3, 'C8GDyLrHJb', 'Amazing Salad!', 499),
       (4, '4MB7UfpTQs', 'Boring Fries!', 199);

insert into promotion (id, code, amount, free_quantity, price, required_quantity, type)
values (1, 'ibt3EEYczW', null, null, 1799, 2, 'QTY_BASED_PRICE_OVERRIDE'),
       (2, 'ZRAwbsO2qM', null, 1, null, 2, 'BUY_X_GET_Y_FREE'),
       (3, 'Gm1piPn7Fg', 10, null, null, null, 'FLAT_PERCENT');

insert into product_promotion (id, code, product_id, promotion_id)
values (1, 'abc123', 1, 1),
       (2, 'abc456', 2, 2),
       (3, 'abc789', 3, 3);
INSERT INTO orders(id, bludo, table_number, server_name)
VALUES ((SELECT nextval('orders_seq')), 'Плов, чай', 1, 'Иван'),
       ((SELECT nextval('orders_seq')), 'Пельмени, сметана, компот', 5, 'Александр'),
       ((SELECT nextval('orders_seq')), 'Суп, хлеб', 2, 'Иван'),
       ((SELECT nextval('orders_seq')), 'Картошка, котлета, соус', 3, 'Иван'),
       ((SELECT nextval('orders_seq')), 'Макароны, куриная грудка', 4, 'Александр'),
       ((SELECT nextval('orders_seq')), 'Гречка, сосиска', 1, 'Иван'),
       ((SELECT nextval('orders_seq')), 'Рис, гуляш', 5, 'Александр'),
       ((SELECT nextval('orders_seq')), 'Каша, масло', 3, 'Иван'),
       ((SELECT nextval('orders_seq')), 'Рис, компот', 2, 'Александр'),
       ((SELECT nextval('orders_seq')), 'Плов', 1, 'Иван');


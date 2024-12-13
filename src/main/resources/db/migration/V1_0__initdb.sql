CREATE SEQUENCE orders_seq;

CREATE TABLE orders
(
    id           BIGINT PRIMARY KEY DEFAULT nextval('orders_seq'),
    bludo        VARCHAR,
    table_number INT,
    server_name  VARCHAR
);

CREATE TABLE IF NOT EXISTS product
(
    id    bigint PRIMARY KEY NOT NULL UNIQUE,
    name  character varying(100)     NOT NULL UNIQUE,
    price double precision NOT NULL
);


CREATE TABLE IF NOT EXISTS discount_card
(
    id     bigint PRIMARY KEY NOT NULL UNIQUE,
    number int    NOT NULL UNIQUE,
    sale   int    NOT NULL
);

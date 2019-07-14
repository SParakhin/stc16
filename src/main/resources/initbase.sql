create schema innobazaar;

create user student with encrypted password 'student123';
grant all privileges on database innobazaar to student;

CREATE DATABASE innobazaar
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'ru_RU.utf-8'
    LC_CTYPE = 'ru_RU.utf-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-----------------------------------------------------
-- Настройка таблиц для безопасности
CREATE TABLE users
(
    username varchar(50) NOT NULL,
    password varchar(68) NOT NULL,
    enabled  smallint    NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE authorities
(
    username  varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,
    CONSTRAINT authorities_idx_1 UNIQUE (username, authority),
    CONSTRAINT authorities_ibsk_1 FOREIGN KEY (username) REFERENCES users (username)
);

-- пример записи с обычным паролем
INSERT INTO public.users (username, password, enabled)
VALUES ('dbmaster', '{noop}qweqwe', 1);
INSERT INTO public.users (username, password, enabled)
VALUES ('dbuser', '{noop}qwe123', 1);

-- пример записи с шифрованным паролем (https://bcrypt-generator.com)
--INSERT INTO public.users (username, password, enabled) VALUES('dbmaster', '{bcrypt}$2y$12$B9UxmWaDyiMnNGWK1htUvu5V1SQkCaIQ0HwoG3oVqvB2SyYksjkCS', 1);
--INSERT INTO public.users (username, password, enabled) VALUES('dbuser', '{bcrypt}$2y$12$NtnKHjNpEXzkJ/IHzpRvyuDaYWAhyARiiTdWK2avX/UdKU6QPIS8G', 1);

INSERT INTO public.authorities (username, authority)
VALUES ('dbmaster', 'ROLE_ADMIN');
INSERT INTO public.authorities (username, authority)
VALUES ('dbuser', 'ROLE_USER');
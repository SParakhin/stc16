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

INSERT INTO public.role (name)
VALUES ('ROLE_ADMIN');
INSERT INTO public.role (name)
VALUES ('ROLE_USER');
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

-------------------------------------------------
-- Создание таблицы логирования запросов
CREATE TABLE public.request_logs
(
    id        serial       NOT NULL,
    log_date date         NULL,
    log_level varchar(5)   NULL,
    message   varchar(255) NULL
)
    WITH (
        OIDS= FALSE
    );
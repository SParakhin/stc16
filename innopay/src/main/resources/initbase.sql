CREATE DATABASE innopay
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'ru_RU.utf-8'
    LC_CTYPE = 'ru_RU.utf-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

grant all privileges on database innopay to student;

INSERT INTO store (id, name, secret_key) VALUES (1, 'innobazaar', '4728ac9e-4618-44ea-8a55-c915c1b33b43');
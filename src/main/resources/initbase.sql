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
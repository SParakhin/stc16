insert into category(name) values ('category1');
insert into category(name) values ('category2');
insert into category(name) values ('category3');
insert into category(name) values ('category4');
insert into category(name) values ('category5');
insert into category(name) values ('category6');
insert into category(name) values ('category7');
insert into merchandise(name, category_id) values ('product_1_1', 1);
insert into merchandise(name, category_id) values ('product_1_2', 1);
insert into merchandise(name, category_id) values ('product_1_3', 1);
insert into merchandise(name, category_id) values ('product_1_4', 1);
insert into merchandise(name, category_id) values ('product_2_1', 2);
insert into merchandise(name, category_id) values ('product_2_1', 2);
insert into merchandise(name, category_id) values ('product_2_1', 2);
insert into merchandise(name, category_id) values ('product_3_1', 3);
insert into merchandise(name, category_id) values ('product_4_1', 4);
insert into merchandise(name, category_id) values ('product_5_1', 5);
insert into merchandise(name, category_id) values ('product_5_2', 5);

insert into stores(id, name, user_id) values (1, 'Ромашка', 1);
insert into merchandise(id, name, price, store_id) values (1, 'Роза', 100, 7);
insert into booking_status(id, status) values (1, 'в обработке');
insert into address(id, address, country, city) values (1, 'ул. Иванова д.5', 'Россия', 'Москва');
insert into booking(id, date, address_id, bookingstatus_id, buyer_id, merchandise_id, count, store_id)
values (1, '12.02.2019', 1, 1, 1, 1, 10, 1);
insert into merchandise(id, name, price, store_id) values (2, 'Фиалка', 100, 1);
insert into booking(id, date, address_id, bookingstatus_id, buyer_id, merchandise_id, count, store_id)
values (2, '12.02.2019', 1, 1, 9, 2, 10, 7);
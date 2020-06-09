/* 
 * 初始化管理员账户
 */


truncate table user;
insert into user (email, password, name, type, gender, age, occupation, zipcode) values ('admin1@outlook.com', '123456', 'admin1', 'admin','M','24','1','100044');
insert into user (email, password, name, type, gender, age, occupation, zipcode) values ('admin2@outlook.com', '123456', 'admin2', 'admin','F','24','5','100044');

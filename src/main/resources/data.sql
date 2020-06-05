/* 
 * 初始化一个管理员账户
 */


truncate table user;
insert into user (email, password, name, type) values ('admin1@outlook.com', '123456', 'admin1', 'admin');
insert into user (email, password, name, type) values ('admin2@outlook.com', '123456', 'admin2', 'admin');

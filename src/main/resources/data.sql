/* 
 * 初始化一个管理员账户
 */


truncate table user;
insert into user (email, password, name, type) values ('admin@outlook.com', '123456', 'admin', 'admin');

1.设置服务器数据库

1.1 数据库url：jdbc:mysql://localhost:3306/UserInformation

1.2 mysql帐号： -u root -p root

1.2 数据库初始化文件（默认添加两个管理员帐号）
user-service\src\main\resources\data.sql


2.微服务接口

2.1查询用户帐号信息
url："/user/{userId}"  
请求类型：GET 
参数：无
返回：User实体（JSON）

2.2用户注册
url："/user/add"  
请求类型：POST 
参数：String name, String email, String password
返回: 处理结果（字符串 “true”或者“false”）

2.3用户登陆
url："/user/login"  
请求类型：POST 
参数：String email, String password
返回：处理结果（字符串 “true”或者“false”）
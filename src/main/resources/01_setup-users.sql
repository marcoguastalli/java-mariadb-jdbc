-- mariadb -u root -p
show databases;
use mysql;
SELECT User, Host FROM mysql.user;
SELECT User, Host FROM mysql.user WHERE Host <> 'localhost';

CREATE USER dbuser@localhost IDENTIFIED BY 'dbuser123';
FLUSH PRIVILEGES;

SET PASSWORD FOR 'root'@localhost = PASSWORD("root123");
ALTER USER 'root'@'localhost' IDENTIFIED BY 'root123';
FLUSH PRIVILEGES;

CREATE DATABASE db;
GRANT ALL PRIVILEGES ON db.* TO 'dbuser'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'dbuser'@'%' IDENTIFIED BY 'dbuser123' WITH GRANT OPTION;
FLUSH PRIVILEGES;
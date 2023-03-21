-- 一本书的书名、作者、出版社、书价、版次
-- 创建数据库 bookmanagement
drop database if exists bookmanagement;
create database if not exists bookmanagement DEFAULT CHARACTER SET utf8mb4;

-- 使用数据库
use bookmanagement;

-- 创建表 book
drop table if exists boook;
create table book(
    id int primary key auto_increment,
    title varchar(32) not null comment "书名",
    author varchar(32) not null comment "作者",
    price varchar(32) not null comment "书的价格",
    press varchar(32) default '' comment "出版社",
    edition int default 0 comment "版次"
    ) default charset 'utf8mb4';
DROP DATABASE IF EXISTS mybatis;

CREATE DATABASE mybatis;

USE mybatis;

DROP TABLE IF EXISTS tbl_employee;

CREATE TABLE tbl_employee(
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
    `last_name` VARCHAR(255),
    `gender` CHAR(1),
    `email` VARCHAR(255)
);

INSERT INTO tbl_employee
VALUES (1, "tom", "0", "tom@atguigu.com");

SELECT * FROM tbl_employee;


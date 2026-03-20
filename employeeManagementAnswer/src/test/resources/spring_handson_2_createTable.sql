-- /*================================================================*/
-- /* テーブル削除            */
-- /*================================================================*/
USE springhandson;

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS member;


-- /*================================================================*/
-- /* employee（従業員）テーブル         */
-- /*================================================================*/
CREATE TABLE employee (
 employee_id INTEGER PRIMARY KEY ,
 employee_name VARCHAR(30) NOT NULL ,
 section VARCHAR(30) NOT NULL ,
 phone VARCHAR(30) NOT NULL,
 version INTEGER NOT NULL DEFAULT 1
);


-- /*================================================================*/
-- /* category（商品カテゴリ）テーブル       */
-- /*================================================================*/
CREATE TABLE category (
 category_id VARCHAR(2) PRIMARY KEY ,
 category_name VARCHAR(40) NOT NULL ,
 picture VARCHAR(30) NOT NULL,
 version INTEGER NOT NULL DEFAULT 1
 );


-- /*================================================================*/
-- /* product（商品）テーブル          */
-- /*================================================================*/
CREATE TABLE product (
 product_id VARCHAR(12) PRIMARY KEY ,
 category_id VARCHAR(2) NOT NULL ,
 product_name VARCHAR(40) NOT NULL ,
 price DECIMAL(7) NOT NULL ,
 picture VARCHAR(30) NOT NULL ,
 point INTEGER NOT NULL ,
 version INTEGER NOT NULL DEFAULT 1,
 FOREIGN KEY(category_id) REFERENCES category(category_id)
);


-- /*================================================================*/
-- /* stock（在庫）テーブル          */
-- /*================================================================*/
CREATE TABLE stock (
 product_id  VARCHAR(12) PRIMARY KEY ,
 quantity  INTEGER   NOT NULL ,
 version INTEGER NOT NULL DEFAULT 1,
 FOREIGN KEY(product_id) REFERENCES product(product_id)
);


-- /*================================================================*/
-- /* MEMBER（会員）テーブル          */
-- /*================================================================*/
CREATE TABLE member (
 member_id  VARCHAR(255) PRIMARY KEY ,
 password  VARCHAR(255)   NOT NULL ,
 member_name  VARCHAR(40)  NOT NULL ,
 gender   CHAR(1)   NOT NULL ,
 address   VARCHAR(80)  NOT NULL ,
 phone   VARCHAR(15)  NOT NULL ,
 member_point  INTEGER   NOT NULL,
 version INTEGER NOT NULL DEFAULT 1
);

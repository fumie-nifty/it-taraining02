-- /*================================================================*/
-- /*  データベース作成                                              */
-- /*================================================================*/
DROP DATABASE IF EXISTS springhandson;

CREATE DATABASE springhandson DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- /*================================================================*/
-- /*  ユーザー作成                                                  */
-- /*================================================================*/
DROP USER IF EXISTS 'springmysql'@localhost;
DROP USER IF EXISTS 'springmysql'@'%';

CREATE USER 'springmysql'@localhost IDENTIFIED BY 'springmysql';
CREATE USER 'springmysql'@'%' IDENTIFIED BY 'springmysql';

-- /*================================================================*/
-- /*  権限設定                                                      */
-- /*================================================================*/
GRANT all ON springhandson.* to 'springmysql'@localhost;
GRANT all ON springhandson.* to 'springmysql'@'%';
FLUSH PRIVILEGES;

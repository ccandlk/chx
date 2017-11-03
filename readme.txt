CREATE TABLE books
(
    id INT PRIMARY KEY NOT NULL,
    bookId VARCHAR(100),
    bookName VARCHAR(100),
    bookState VARCHAR(100),
    uploadAuthor VARCHAR(100),
    phoneNumber VARCHAR(100)
) default charset = utf8;

CREATE UNIQUE INDEX books_id_uindex ON books (id);


SHOW VARIABLES LIKE 'character_set_%';


-- auto-generated definition
CREATE TABLE users
(
  userId   INT PRIMARY KEY NOT NULL,
  username VARCHAR(100) NULL,
  password VARCHAR(100) NULL,
) default charset = utf8;


http://blog.didispace.com/springbootsecurity/
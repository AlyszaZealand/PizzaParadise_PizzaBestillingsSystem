CREATE TABLE IF NOT EXISTS topping ( ... );
CREATE TABLE IF NOT EXISTS pizza ( ... );
CREATE TABLE IF NOT EXISTS user ( ... );
CREATE TABLE IF NOT EXISTS ordre ( ... );

CREATE TABLE topping (
                         id    INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                         name  VARCHAR(50) NOT NULL,
                         price DOUBLE      NOT NULL
);

CREATE TABLE pizza (
                       id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                       name        VARCHAR(50)  NOT NULL,
                       description VARCHAR(255) NOT NULL,
                       price       DOUBLE       NOT NULL,
                       toppingId   INT,
                       FOREIGN KEY (toppingId) REFERENCES topping(id)
);

CREATE TABLE user (
                      id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                      name        VARCHAR(50)  NOT NULL,
                      email       VARCHAR(50)  NOT NULL UNIQUE,
                      address     VARCHAR(255) NOT NULL,
                      bonuspoints INT          NOT NULL DEFAULT 0
);

CREATE TABLE ordre (
                       id         INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                       date       DATETIME NOT NULL,
                       totalprice DOUBLE   NOT NULL,
                       pizzaid    INT,
                       userid     INT,
                       FOREIGN KEY (pizzaid) REFERENCES pizza(id),
                       FOREIGN KEY (userid)  REFERENCES user(id)
);




-- DROP TABLE IF EXISTS pizza;
-- DROP TABLE IF EXISTS user;
-- DROP TABLE IF EXISTS ordre;
-- DROP table if exists topping;
--
-- create table topping(
--                         id int primary key auto_increment not null,
--                         name varchar(50) not null,
--                         price double not null
-- );
--
-- create table pizza(
--                       id int primary key auto_increment not null,
--                       name varchar(50) not null,
--                       description varchar(255) not null,
--                       price double not null,
--                       toppingId int,
--                       foreign key (toppingId) references topping(id)
-- );
--
--
-- create table user(
--                      id int primary key auto_increment not null,
--                      name varchar(50) not null,
--                      email varchar(50) not null,
--                      address varchar(255) not null,
--                      bonusPoints int
-- );
-- create table ordre(
--                       id int primary key auto_increment not null,
--                       date datetime,
--                       totalPrice double,
--                       pizzaid int,
--                       foreign key (pizzaid) references pizza(id),
--                       userid int,
--                       foreign key (userid) references user(id)
-- );

-- ALTER TABLE user ADD COLUMN userID INT AUTO_INCREMENT PRIMARY KEY;
-- ALTER TABLE user ADD COLUMN userID INT NOT NULL;
-- ALTER TABLE user ADD COLUMN userID INT NOT NULL REFERENCES user(id)

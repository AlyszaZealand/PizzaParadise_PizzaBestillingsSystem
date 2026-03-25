
create table pizza(
                      id int primary key auto_increment not null,
                      name varchar(50) not null,
                      description varchar(255) not null,
                      price double not null,
                      toppingId int,
                      foreign key (toppingId) references topping(id)
);

create table topping(
                        id int primary key auto_increment not null,
                        name varchar(50) not null,
                        price double not null
);

create table ordre(
                      id int primary key auto_increment not null,
                      date datetime,
                      totalPrice double,
                      pizzaid int,
                      foreign key (pizzaid) references pizza(id),
                      userid int,
                      foreign key (userid) references user(id)
);

create table user(
                     id int primary key auto_increment not null,
                     name varchar(50) not null,
                     email varchar(50) not null,
                     address varchar(255) not null,
                     bonusPoints int
);

-- ALTER TABLE user ADD COLUMN userID INT AUTO_INCREMENT PRIMARY KEY;
-- ALTER TABLE user ADD COLUMN userID INT NOT NULL;
-- ALTER TABLE user ADD COLUMN userID INT NOT NULL REFERENCES user(id)

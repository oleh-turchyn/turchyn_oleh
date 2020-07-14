create table Сlients(
id int primary key,
first_name varchar(30),
last_name varchar(30),
patron_name varchar(30),
passport varchar(30),
tel_num varchar(30)
);

create table Tours(
id int primary key,
title varchar(30),
location varchar(30),
transport varchar(30),
nutrition varchar(30),
duration int,
price int
);

create table TourOrder(
order_id INTEGER NOT NULL,
date_order DATE NOT NULL,
client_code INTEGER NOT NULL,
tour_code INTEGER NOT
PRIMARY KEY (order
CONSTRAINT clientk FOREIGN KEY (client_code) REFERENCES Clients
    ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT tourk FOREIGN KEY (tour_code) REFERENCES TOURS
    ON DELETE CASCADE ON UPDATE CASCADE
);
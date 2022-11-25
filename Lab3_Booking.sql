CREATE DATABASE IF NOT EXISTS hotelsBooking;
USE hotelsBooking;

DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS hotel_room;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS hotels_branch;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS dates;






CREATE TABLE dates (id INT NOT NULL auto_increment PRIMARY KEY,
 arriving DATE NOT NULL,
 departure DATE NOT NULL) 
 ENGINE=InnoDB;
 
 CREATE TABLE location (id INT NOT NULL auto_increment PRIMARY KEY,
 city VARCHAR(45) NOT NULL,
 street VARCHAR(45) NOT NULL,
 country_name VARCHAR(45) NOT NULL)
 ENGINE=InnoDB;
 
 CREATE TABLE hotels_branch (id INT NOT NULL auto_increment PRIMARY KEY,
 number_of_hotels INT NOT NULL,
 name VARCHAR(45) NOT NULL,
 location_id INT NOT NULL,
CONSTRAINT fk_location_id FOREIGN KEY(location_id) REFERENCES location(id)) ENGINE=InnoDB;

CREATE TABLE hotel (id INT NOT NULL auto_increment PRIMARY KEY,
 name VARCHAR(45) NOT NULL,
 number_of_rooms INT NOT NULL,
 hotels_branch_id INT NOT NULL,
CONSTRAINT fk_hotels_branch_id FOREIGN KEY(hotels_branch_id) REFERENCES hotels_branch(id)) ENGINE=InnoDB;

CREATE TABLE hotel_room (id INT NOT NULL auto_increment PRIMARY KEY,
 number_of_places INT NOT NULL,
 is_free TINYINT NOT NULL,
 price INT NOT NULL,
 hotel_id INT NOT NULL,
CONSTRAINT fk_hotel_id FOREIGN KEY(hotel_id) REFERENCES hotel(id)) ENGINE=InnoDB;

CREATE TABLE reservation (id INT NOT NULL auto_increment PRIMARY KEY,
 days_of_rezervation INT NOT NULL,
 is_paid TINYINT NOT NULL,
 dates_id INT NOT NULL,
 hotel_room_id INT NOT NULL,
CONSTRAINT fk_dates_id FOREIGN KEY(dates_id) REFERENCES dates(id),
CONSTRAINT fk_hotel_room_id FOREIGN KEY(hotel_room_id) REFERENCES hotel_room(id)) ENGINE=InnoDB;

CREATE TABLE user (id INT NOT NULL auto_increment PRIMARY KEY,
 first_name VARCHAR(45) NOT NULL,
 last_name VARCHAR(45) NOT NULL,
 personal_card VARCHAR(45) NOT NULL,
 reservation_id INT NOT NULL,
CONSTRAINT fk_reservation_id FOREIGN KEY(reservation_id) REFERENCES reservation(id)) ENGINE=InnoDB;

 CREATE TABLE review (id INT NOT NULL auto_increment PRIMARY KEY,
 stars INT NOT NULL,
 comment VARCHAR(150) NOT NULL,
 user_id INT NOT NULL,
 hotel_id INT NOT NULL,
CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES user(id),
CONSTRAINT fk_hotel_id1 FOREIGN KEY(hotel_id) REFERENCES hotel(id)) ENGINE=InnoDB;

INSERT INTO dates VALUES (1,'2008-10-22','2012-10-22'),(2,'2019-10-22','2018-10-22'),(3,'2028-10-22','2019-10-22'),(4,'2001-11-22','2005-11-22'),(5,'2005-11-22','2008-11-22'),(6,'2009-11-22','2011-11-22'),(7,'2009-11-22','2015-11-22'),(8,'2016-11-22','2021-11-22'),(9,'2019-11-22','2025-11-22'),(10,'2021-11-22','2026-11-22');
INSERT INTO location VALUES (1,'Hurghada','Patrasia','Egypt'),(2,'Toronto','Chensia','Canada'),(3,'London','Syur','England'),(4,'Paris','Rancee','France'),(5,'Naples','Chensia','Italy'),(6,'Krakow','Petrisia','Poland'),(7,'Barcelona','Soritea','Spain'),(8,'Istanbul','Nuiira','Turkey'),(9,'Lviv','Shevchenka','Ukraine'),(10,'New York','Roodie','USA');
INSERT INTO hotels_branch VALUES (1,7,"Jin Jiang",1),(2,8,"Hilton Hotels",2),(3,6,"Accor Group",3),(4,10,"Marriott International",4),(5,8,"OYO",5),(6,4,'IHG',6),(7,6,"Wyndham Hotel Group",7),(8,8,"Huazhu",8),(9,5,"Hilton Hotels",9),(10,11,"Choice Hotels",10);
INSERT INTO hotel VALUES (1,"Jinjiang",120,1),(2,"Hilton Garden Inn Rzeszów",140,2),(3,"RAFFLES",550,3),(4,"Hotel Irla",200,4),(5,"Occitano Apart Hotel",200,5),(6,"Clarion Congress Hotel",100,6),(7,"Kalma Sitges Hotel",100,7),(8,"Clarion Hotel Golden Horn",100,8),(9,"Grand Hotel Lviv",40,9),(10,"Quality Hotel Coventry",100,10);
INSERT INTO hotel_room VALUES (1,5,true,100,10),(2,4,true,200,9),(3,3,false,300,8),(4,5,true,400,6),(5,5,false,521,7),(6,5,true,601,1),(7,5,true,214,2),(8,4,true,821,3),(9,5,false,211,4),(10,3,false,122,5);
INSERT INTO reservation VALUES (1,5,true,1,10),(2,4,true,2,9),(3,3,false,3,8),(4,5,true,4,6),(5,5,false,5,7),(6,5,true,6,1),(7,5,true,7,2),(8,4,true,8,3),(9,5,false,9,4),(10,3,false,10,5);
INSERT INTO user VALUES (1,"Valeri","Sterneo",8646383952,1),(2,"Denys","Renie",4511952565,2),(3,"Ostap","Folety",2602708495,3),(4,"Oscar","Valley",3031451965,4),(5,"Gio","Hippoo",5911549165,6),(6,"Doa","Nica",7282810691,8),(7,"Cooal","Kirogna",1348638024,10),(8,"Sofia","Petrushko",3863327148,9),(9,"Balii","Poluad",7477908018,7),(10,"Nias","Dilan",6705003100,5);
INSERT INTO review VALUES (1,5,"Suuuper",1,10),(2,4,"Good",2,9),(3,3,"Accor Group",3,8),(4,5,"Amazing rooms",4,6),(5,5,"Amazing view",5,7),(6,5,"Amazing pool",6,1),(7,5,"Very clean and tasty",7,2),(8,4,"Good",8,3),(9,5,"Exelent",9,4),(10,3,"Horrible breakfsts",10,5);

CREATE INDEX hotels_branch_idx ON hotels_branch(number_of_hotels);
CREATE INDEX hotel_idx ON hotel(number_of_rooms);
CREATE INDEX hotel_room_idx ON hotel_room(number_of_places, price);

SHOW INDEX FROM hotels_branch;
SHOW INDEX FROM hotel;
SHOW INDEX FROM hotel_room;

































																		
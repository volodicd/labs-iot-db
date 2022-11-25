USE lab5_db;

INSERT INTO location (city, street, country_name) VALUES ('Hurghada','Patrasia','Egypt'),('Toronto','Chensia','Canada'),('London','Syur','England'),('Paris','Rancee','France'),('Naples','Chensia','Italy'),('Krakow','Petrisia','Poland'),('Barcelona','Soritea','Spain'),('Istanbul','Nuiira','Turkey'),('Lviv','Shevchenka','Ukraine'),('New York','Roodie','USA');
INSERT INTO hotels_branch(number_of_hotels, name, location_id) VALUES (7,'Jin Jiang',1),(8,'Hilton Hotels',2),(6,'Accor Group',3),(10,'Marriott International',4),(8,'OYO',5),(4,'IHG',6),(6,'Wyndham Hotel Group',7),(8,'Huazhu',8),(5,'Hilton Hotels',9),(11,'Choice Hotels',10);

INSERT INTO hotel(name, number_of_rooms, hotels_branch_id) VALUES ('Jinjiang',120,1),('Hilton Garden Inn Rzeszów',140,2),('RAFFLES',550,3),('Hotel Irla',200,4),('Occitano Apart Hotel',200,5),('Clarion Congress Hotel',100,6),('Kalma Sitges Hotel',100,7),('Clarion Hotel Golden Horn',100,8),('Grand Hotel Lviv',40,9),('Quality Hotel Coventry',100,10);
INSERT INTO hotel_room(number_of_places, is_free, price, hotel_id) VALUES (5,true,100,10),(4,true,200,9),(3,false,300,8),(5,true,400,6),(5,false,521,7),(5,true,601,1),(5,true,214,2),(4,true,821,3),(5,false,211,4),(3,false,122,5);
INSERT INTO reservation(days_of_rezervation, is_paid, hotel_room_id) VALUES (5,true,10),(4,true,9),(3,false,8),(5,true,6),(5,false,7),(5,true,1),(5,true,2),(4,true,3),(5,false,4),(3,false,5);

USE lab5_db;

DROP FUNCTION IF EXISTS max_hotels_number;

DELIMITER //
CREATE FUNCTION max_hotels_number()
    RETURNS INTEGER
BEGIN
    DECLARE hotels_number INTEGER;
SELECT MAX(hotels)
INTO max_hotels_number
FROM hotels_branch;
RETURN max_hotels_number;
END; //
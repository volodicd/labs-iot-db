USE Labor_SQL;
-- 1. БД «Комп. фірма». Знайти модель та частоту процесора
-- комп’ютерів, що коштують від 400 до 600 дол. Вивести: model, speed.
-- Вихідні дані впорядкувати за зростанням за стовпцем hd.
SELECT model, speed
FROM PC
WHERE price BETWEEN 400 AND 600
ORDER BY hd;

-- 2. БД «Аеропорт». З таблиці Pass_in_trip вивести дати, коли були
-- зайняті місця в першому ряді.
SELECT date
FROM Pass_in_trip
WHERE place LIKE '1%';
-- 3. БД «Комп. фірма». Виведіть виробника, номер моделі та ціну
-- кожного комп’ютера, що є в БД. Вивести: maker, model, price.
SELECT maker, pc.model, price
FROM product 
JOIN PC ON product.model = PC.model;  
-- 4. БД «Комп. фірма». Знайти тих виробників ПК, для яких не всі
-- моделі ПК є в наявності в таблиці PC (використовувати вкладені
-- підзапити та оператори IN, ALL, ANY). Вивести maker.
SELECT maker FROM product 
WHERE type = 'pc' AND model NOT IN (SELECT model FROM pc) 
GROUP BY maker;

-- 5. БД «Комп. фірма». Знайдіть виробників принтерів, що випускають
-- ПК із найменшим об’ємом RAM. Виведіть: maker.
SELECT maker FROM product
LEFT JOIN pc
ON product.model = pc.model
WHERE ram = ANY(SELECT min(ram) from pc) AND maker in (SELECT maker FROM product WHERE type = 'Printer')
GROUP BY maker;

-- 6. БД «Кораблі». З таблиці Battles виведіть дати в такому форматі:
-- день.число_місяця.рік, наприклад, 12.06.2001 (без формату часу).
SELECT DATE_FORMAT(date, '%d.%m.%Y') FROM Battles;

-- 7. БД «Аеропорт». Визначіть кількість рейсів із міста 'London' для
-- кожної дати таблиці Pass_in_trip. Вивести: date, число рейсів.

SELECT date, count(*) 'number of flights' 
FROM trip JOIN Pass_in_trip ON trip.trip_no = Pass_in_trip.trip_no 
WHERE trip.town_from = 'London' 
GROUP BY date;
-- 8. БД «Кораблі». Вкажіть назву, водотоннажність та число гармат
-- кораблів, що брали участь у битві при 'Guadalcanal'. Вивести: ship,
-- displacement, numGuns. (Підказка: використовувати підзапити в
-- якості обчислювальних стовпців)

SELECT ship, displacement, numGuns 
FROM classes 
JOIN (SELECT * FROM outcomes JOIN ships ON outcomes.ship = ships.name
WHERE battle = 'Guadalcanal') as subquery ON classes.class =subquery.class; 

-- 9. БД «Фірма прий. вторсировини». Приймаючи, що прихід та розхід
-- грошей на кожному пункті прийому фіксується не частіше одного
-- разу на день (лише таблиці Income_o та Outcome_o), написати запит із
-- такими вихідними даними: point (пункт), date (дата), inc (прихід), out
-- (розхід). (Підказка: використовувати зовнішнє з’єднання та оператор
-- CASE)
SELECT income_o.point, DATE(income_o.date) date, ROUND(income_o.inc) inc,
ROUND(CASE
	WHEN outcome_o.out IS NOT NULL THEN outcome_o.out
    ELSE 0
END) AS "out"
FROM income_o 
LEFT JOIN outcome_o ON income_o.point = outcome_o.point AND income_o.date = outcome_o.date
UNION
SELECT outcome_o.point, DATE(outcome_o.date) date,
ROUND(CASE
	WHEN income_o.inc IS NOT NULL THEN income_o.inc
    ELSE 0
END) AS inc,
ROUND(outcome_o.out) AS "out"
FROM income_o 
RIGHT JOIN outcome_o ON income_o.point = outcome_o.point AND income_o.date = outcome_o.date 
ORDER BY date;



-- 10. БД «Кораблі». Знайти назви всіх кораблів у БД, що складаються із
-- двох та більше слів (наприклад, 'King George V'). Вважати, що слова в
-- назвах розділяються одиничними пробілами, та немає кінцевих пробі-
-- лів. Вивести: назву кораблів. (Підказка: використовувати оператор
-- UNION )

SELECT name FROM ships
WHERE name RLIKE '.+\\s.+'
UNION
SELECT ship FROM outcomes
WHERE ship RLIKE '.+\\s.+';


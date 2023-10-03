-- 7. В подключенном MySQL репозитории создать базу данных “Друзья
-- человека”

CREATE DATABASE humanfriends;
USE humanfriends;

-- 8. Создать таблицы с иерархией из диаграммы в БД

CREATE TABLE animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	type VARCHAR(30) NOT NULL
);

CREATE TABLE pets (
	id INT PRIMARY KEY AUTO_INCREMENT,
	type_id INT NOT NULL,
	class varchar(30) NOT NULL

);
CREATE TABLE packanimals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	type_id  INT NOT NULL,
	class VARCHAR(30) NOT NULL
);

CREATE TABLE cats (
	id INT PRIMARY KEY AUTO_INCREMENT,
	class_id INT NOT NULL,
	name VARCHAR(30) NOT NULL,
  birth DATE NOT NULL,
  commands TEXT
);

CREATE TABLE dogs (
	id INT PRIMARY KEY AUTO_INCREMENT,
	class_id INT NOT NULL,
	name VARCHAR(30) NOT NULL,
  birth DATE NOT NULL,
  commands TEXT
);

CREATE TABLE hamsters (
	id INT PRIMARY KEY AUTO_INCREMENT,
	class_id INT NOT NULL,
	name VARCHAR(30) NOT NULL,
  birth DATE NOT NULL,
  commands TEXT
);

CREATE TABLE horses (
	id INT PRIMARY KEY AUTO_INCREMENT,
	class_id INT NOT NULL,
	name VARCHAR(30) NOT NULL,
  birth DATE NOT NULL,
  commands TEXT
);

CREATE TABLE camels (
	id INT PRIMARY KEY AUTO_INCREMENT,
	class_id INT NOT NULL,
	name VARCHAR(30) NOT NULL,
  birth DATE NOT NULL,
  commands TEXT
);

CREATE TABLE donkeys (
	id INT PRIMARY KEY AUTO_INCREMENT,
	class_id INT NOT NULL,
	name VARCHAR(30) NOT NULL,
  birth DATE NOT NULL,
  commands TEXT
);

-- 9. Заполнить низкоуровневые таблицы именами(животных), командами
-- которые они выполняют и датами рождения

INSERT INTO animals (type) VALUES 
	('Домашние животные'),
	('Вьючные животные');

INSERT INTO pets (type_id,class) VALUES 
	(1,'Кошки'),
	(1,'Собаки'),
	(1,'Хомяки');

INSERT INTO packanimals (type_id,class) VALUES 
	(2,'Лошади'),
	(2,'Верблюды'),
	(2,'Ослы');
	

INSERT INTO cats (name,commands, birth, class_id) VALUES 
	('Пират', 'мяу', '2022-04-01',1),
	('Барсик', 'мяу, сидеть', '2022-12-11',1),
  ('Беляш', 'мяу, лежать', '2022-03-02',1),
  ('Мурка', 'мяу', '2022-05-06',1);
   
INSERT INTO dogs (name,commands, birth, class_id) VALUES 
	('Бобик', 'голос, сидеть', '2021-01-01',2),
	('Барбос', 'голос', '2019-12-10',2),
  ('Дружок', 'голос, лежать', '2020-02-02',2);
 
    
INSERT INTO hamsters (name,commands, birth, class_id) VALUES 
	('Малыш', 'есть', '2021-01-01',3),
	('Добряк', 'есть, бежать', '2019-12-10',3),
  ('Серый', 'есть, спать', '2020-02-02',3);
    
INSERT INTO horses (name,commands, birth, class_id) VALUES 
	('Гром', 'ну, тпру', '2021-01-01',1),
	('Мальчик', 'ну, тпру, лево', '2019-12-10',1),
    ('Мишка', 'ну, тпру, право', '2020-02-02',1);
    
INSERT INTO camels (name,commands, birth, class_id) VALUES 
	('Горбатый', 'сидеть, лежать', '2021-01-01',2),
	('Быстрый', 'сидеть', '2019-12-10',2),
    ('Смелый', 'лежать', '2020-02-02',2);
 
    
INSERT INTO donkeys (name,commands, birth, class_id) VALUES 
	('Стёпа', 'вперёд, стоп', '2021-01-01',3),
	('Тузик', 'вперёд, назад', '2019-12-10',3),
    ('Мурзик', 'вперёд', '2020-02-02',3);

-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

TRUNCATE camels;

INSERT INTO horses (name, commands, birth, class_id)
SELECT name, commands, birth, class_id
FROM donkeys;

DROP TABLE donkeys;

RENAME TABLE horses TO horses_donkeys;

-- 11. Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице

CREATE TABLE youngsters (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(30),
    commands TEXT,
    birth DATE,
		class_id INT,
    age TEXT
);

DROP FUNCTION IF EXISTS age;
DELIMITER $$
CREATE FUNCTION age (birthday DATE)
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE res TEXT DEFAULT '';
	SET res = CONCAT(
            TIMESTAMPDIFF(YEAR, birthday, CURDATE()),
            ' years ',
            TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,
            ' months'
        );
	RETURN res;
END $$
DELIMITER ;


INSERT INTO youngsters (name, commands, birth,class_id, age)
SELECT name, commands, birth, class_id,age(birth)
FROM cats
WHERE TIMESTAMPDIFF(YEAR, birth, CURDATE()) BETWEEN 1 AND 2
UNION ALL
SELECT name, commands, birth, class_id,age(birth)
FROM dogs
WHERE TIMESTAMPDIFF(YEAR, birth, CURDATE()) BETWEEN 1 AND 2
UNION ALL
SELECT name, commands, birth, class_id,age(birth)
FROM hamsters
WHERE TIMESTAMPDIFF(YEAR, birth, CURDATE()) BETWEEN 1 AND 2
UNION ALL
SELECT name, commands, birth, class_id,age(birth)
FROM horses_donkeys
WHERE TIMESTAMPDIFF(YEAR, birth, CURDATE()) BETWEEN 1 AND 2;


-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

CREATE TABLE new_table

SELECT  dogs.name, dogs.commands, dogs.birth, pets.class AS 'из таблицы'
FROM dogs
LEFT JOIN pets ON pets.id = dogs.class_id
UNION ALL
SELECT  cats.name,cats.commands, cats.birth, pets.class AS 'из таблицы'
FROM cats
LEFT JOIN pets ON pets.id = cats.class_id
UNION ALL
SELECT  hamsters.name,hamsters.commands, hamsters.birth, pets.class AS 'из таблицы'
FROM hamsters
LEFT JOIN pets ON pets.id = hamsters.class_id
UNION ALL
SELECT  horses_donkeys.name, horses_donkeys.commands, horses_donkeys.birth,packanimals.class AS 'из таблицы'
FROM horses_donkeys
LEFT JOIN packanimals ON packanimals.id = horses_donkeys.class_id


DROP TABLE IF EXISTS `movie` CASCADE;
CREATE TABLE movie (
	`id` BIGINT primary key auto_increment,
	`age` integer check (age<=20 AND age>=2),
	`director` VARCHAR(255),
	`rating` DOUBLE,
	`name` VARCHAR(255) not null unique
);
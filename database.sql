CREATE DATABASE IF NOT EXISTS airport_db;
USE airport_db;

CREATE TABLE flights (
    id INT AUTO_INCREMENT PRIMARY KEY,
    flight_no VARCHAR(50),
    origin VARCHAR(100),
    destination VARCHAR(100)
);

CREATE TABLE passengers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    passport VARCHAR(50)
);

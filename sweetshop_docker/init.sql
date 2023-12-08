CREATE DATABASE IF NOT EXISTS sweetshop;
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'user'@'%';
FLUSH PRIVILEGES;
CREATE TABLE cakes (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       price INT NOT NULL,
                       being INT NOT NULL
);
CREATE TABLE basket (
                        id SERIAL PRIMARY KEY,
                        cakeId INT NOT NULL,
);
ALTER TABLE basket ADD FOREIGN KEY (cakeId) REFERENCES cakes(id);
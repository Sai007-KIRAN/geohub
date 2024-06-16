
CREATE TABLE if not exists country (
    countryId INT PRIMARY KEY AUTO_INCREMENT,
    countryName varchar(255),
    currency varchar(255),
    population INT,
    latitude varchar(255),
    longitude varchar(255)
);

CREATE TABLE if not exists city (
    cityId INT PRIMARY KEY AUTO_INCREMENT,
    cityName varchar(255),
    population INT,
    latitude varchar(255),
    longitude varchar(255),
    countryId INT,
    FOREIGN KEY (countryId) REFERENCES country (countryId)
);

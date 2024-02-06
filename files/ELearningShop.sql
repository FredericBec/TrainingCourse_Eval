-- Base de données de l'application de vente de formations

-- création de la base de données
DROP DATABASE IF EXISTS ELearningShop;
CREATE DATABASE ELearningShop;
USE ELearningShop;

-- création des tables 
CREATE TABLE T_Categories(
	IdCategory		int(4)		PRIMARY KEY AUTO_INCREMENT,
	CatName			VARCHAR(30) NOT NULL,
	Description 	VARCHAR(50) NOT NULL
)ENGINE = InnoDB;

CREATE TABLE T_TrainingCourses(
	IdTrainingCourse int(4)		 PRIMARY KEY AUTO_INCREMENT,
	Name			 VARCHAR(20) NOT NULL,
	Description		 VARCHAR(50) NOT NULL,
	Duration		 int(4)		 NOT NULL,
	Price			 float(8)	 NOT NULL
)ENGINE = InnoDB;

CREATE TABLE T_Users(
	IdUser		int(4)		PRIMARY KEY AUTO_INCREMENT,
	Login		varchar(20) NOT NULL,
	Password	varchar(20) NOT NULL
)ENGINE = InnoDB;

CREATE TABLE T_Customers(
	IdCustomer	int(4)		 PRIMARY KEY AUTO_INCREMENT,
	Name		VARCHAR(30)	 NOT NULL,
	FirstName	VARCHAR(30)	 NOT NULL,
	Address		VARCHAR(100) NOT NULL,
	Email		VARCHAR(50)  NOT NULL,
	Phone		VARCHAR(15)  NOT NULL
)ENGINE = InnoDB;

CREATE TABLE T_Orders(
	IdOrder		int(4)		 PRIMARY KEY AUTO_INCREMENT,
	Name		VARCHAR(30)	 NOT NULL,
	TotalAmount float(8)	 NOT NULL,
	DateOrder	date		 NOT NULL
)ENGINE = InnoDB;

CREATE TABLE T_OrderItems(
	IdOrderItem	int(4)		 PRIMARY KEY AUTO_INCREMENT,
	Quantity	int(4)		 NULL,
	Amount		float(8)	 NULL
)ENGINE = InnoDB;

-- Ajout des clés étrangères
ALTER TABLE T_TrainingCourses ADD COLUMN IdCategory int(4);
ALTER TABLE T_TrainingCourses ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);
ALTER TABLE T_OrderItems ADD COLUMN IdTrainingCourse int(4);
ALTER TABLE T_OrderItems ADD FOREIGN KEY(IdTrainingCourse) REFERENCES T_TrainingCourses(IdTrainingCourse);
ALTER TABLE T_OrderItems ADD COLUMN IdOrder int(4);
ALTER TABLE T_OrderItems ADD FOREIGN KEY(IdOrder) REFERENCES T_Orders(IdOrder);
ALTER TABLE T_Orders ADD COLUMN IdCustomer int(4);
ALTER TABLE T_Orders ADD FOREIGN KEY(IdCustomer) REFERENCES T_Customers(IdCustomer);
ALTER TABLE T_Customers ADD COLUMN IdUser int(4);
ALTER TABLE T_Customers ADD FOREIGN KEY(IdUser) REFERENCES T_Users(IdUser);

-- Insertion des données dans les tables T_TrainingCourses et T_Categories
INSERT INTO T_Categories (CatName, Description) VALUES ("Back-end","Language, IDE, SGBD...");
INSERT INTO T_Categories (CatName, Description) VALUES ("Front-end","Language, IDE front, composant, ...");
INSERT INTO T_Categories (CatName, Description) VALUES ("Frameworks","Tous les frameworks utilisables d'applications");
INSERT INTO T_Categories (CatName, Description) VALUES ("Api","lien entre le Back-end et le Front-end");

INSERT INTO T_TrainingCourses (Name, Description, Duration, Price, IdCategory) VALUES ("Java","Java SE 8 : Syntaxe & Poo", 20, 1000.0, 1);
INSERT INTO T_TrainingCourses (Name, Description, Duration, Price, IdCategory) VALUES ("Java avancé","Exceptions, fichiers, jdbc, thread...", 20, 1100.0, 1);
INSERT INTO T_TrainingCourses (Name, Description, Duration, Price, IdCategory) VALUES ("Spring","Spring Core/MVC/Security", 20, 500.0, 4);
INSERT INTO T_TrainingCourses (Name, Description, Duration, Price, IdCategory) VALUES ("Php frameworks","Symphony", 15, 940.0, 3);
INSERT INTO T_TrainingCourses (Name, Description, Duration, Price, IdCategory) VALUES ("C#","DotNet Core", 20, 3000.0, 1);

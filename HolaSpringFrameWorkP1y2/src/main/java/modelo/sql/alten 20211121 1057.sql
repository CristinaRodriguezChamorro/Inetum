-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.13-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema alten
--

CREATE DATABASE IF NOT EXISTS alten;
USE alten;

--
-- Definition of table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE `alumnos` (
  `ALU_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ALU_APELLIDO` varchar(45) NOT NULL,
  `ALU_NOMBRE` varchar(45) NOT NULL,
  `ALU_EMAIL` varchar(45) NOT NULL,
  `ALU_CONOCIMIENTOS` varchar(200) NOT NULL,
  `ALU_GIT` varchar(200) NOT NULL,
  `ALU_OBSERVACIONES` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ALU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `alumnos`
--

/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` (`ALU_ID`,`ALU_APELLIDO`,`ALU_NOMBRE`,`ALU_EMAIL`,`ALU_CONOCIMIENTOS`,`ALU_GIT`,`ALU_OBSERVACIONES`) VALUES 
 (1,'CASTRO PINTADO',' ERIKA ROXANA','','conocimientos base de datos','https://github.com/erika2198/Curso_Spring.git',NULL),
 (2,'FERNANDEZ COBOS','ALBA',' ','conocimientos base de datos','https://github.com/albafernandezcobos/springbootalten.git',NULL),
 (3,'Mora Rubio','Ivan','','conocimientos de tecnologia maven spring git','https://gitlab.com/ivan.mora/proyectoivan.git',NULL),
 (4,'Repillosa Ulloa','Yelitza','','conocimientos de maven git','https://gitlab.com/yelirepillosa/curso_spring_boot_2021.git',NULL),
 (5,'Gómez Martin','Victor','','conocimientos de maven git','https://gitlab.com/victor301/springboot_2021.git',NULL),
 (6,'Malmierca Martin','Antonio','','4 meses de experiencia, java sel','https://gitlab.com/antonio.malmierca.martin/springboot_2021.git',NULL);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;


--
-- Definition of table `evaluaciones`
--

DROP TABLE IF EXISTS `evaluaciones`;
CREATE TABLE `evaluaciones` (
  `EVA_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EVA_NOMBRE` varchar(45) NOT NULL,
  `EVA_FECHA` date NOT NULL,
  `EVA_RESULTADO` float NOT NULL,
  `EVA_OBSERVACIONES` varchar(45) NOT NULL,
  `ALU_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`EVA_ID`),
  KEY `FK_EVALUACIONES_ALUMNOS` (`ALU_ID`),
  CONSTRAINT `FK_EVALUACIONES_ALUMNOS` FOREIGN KEY (`ALU_ID`) REFERENCES `alumnos` (`ALU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `evaluaciones`
--

/*!40000 ALTER TABLE `evaluaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluaciones` ENABLE KEYS */;


--
-- Definition of table `practicas`
--

DROP TABLE IF EXISTS `practicas`;
CREATE TABLE `practicas` (
  `PRAC_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PRAC_NOMBRE` varchar(45) NOT NULL,
  PRIMARY KEY (`PRAC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `practicas`
--

/*!40000 ALTER TABLE `practicas` DISABLE KEYS */;
INSERT INTO `practicas` (`PRAC_ID`,`PRAC_NOMBRE`) VALUES 
 (1,'Practica 0- piedra papel y tiera'),
 (2,'Practica 1 Spring-core'),
 (3,'Practica 1 Spring-core-piedra-papel-tijera');
/*!40000 ALTER TABLE `practicas` ENABLE KEYS */;


--
-- Definition of table `practicasresueltas`
--

DROP TABLE IF EXISTS `practicasresueltas`;
CREATE TABLE `practicasresueltas` (
  `PR_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `PRAC_ID` int(10) unsigned NOT NULL,
  `ALU_ID` int(10) unsigned NOT NULL,
  `PR_NOTA` float NOT NULL,
  `PR_OBSERVACIONES` varchar(500) NOT NULL,
  PRIMARY KEY (`PR_ID`),
  UNIQUE KEY `constr_AluId_prac_id` (`PRAC_ID`,`ALU_ID`),
  KEY `FK_practicasresuelta_PRACTICA` (`PRAC_ID`),
  KEY `FK_practicasresuelta_ALUMNOS` (`ALU_ID`),
  CONSTRAINT `FK_practicasresuelta_ALUMNOS` FOREIGN KEY (`ALU_ID`) REFERENCES `alumnos` (`ALU_ID`),
  CONSTRAINT `FK_practicasresuelta_PRACTICA` FOREIGN KEY (`PRAC_ID`) REFERENCES `practicas` (`PRAC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `practicasresueltas`
--

/*!40000 ALTER TABLE `practicasresueltas` DISABLE KEYS */;
INSERT INTO `practicasresueltas` (`PR_ID`,`PRAC_ID`,`ALU_ID`,`PR_NOTA`,`PR_OBSERVACIONES`) VALUES 
 (1,1,1,10,'19/11 me encantaron los textos en las comparaciones'),
 (2,1,2,8,'18/11 faltan completar las clases lagarto y spock y sus correspondientes testeos'),
 (3,1,3,10,'18/11 Me encanto creo que estan todas las variantes'),
 (4,1,4,10,'18/11 Me encanto creo que estan todas las variantes'),
 (5,1,5,9,'19/11 agregar lagarto y spock en el factory y en el teste el getInstance'),
 (6,1,6,10,'19/11 se modifico el por constructor vacio');
/*!40000 ALTER TABLE `practicasresueltas` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

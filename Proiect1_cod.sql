-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema project1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema project1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `project1` DEFAULT CHARACTER SET utf8 ;
USE `project1` ;

-- -----------------------------------------------------
-- Table `project1`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project1`.`student` (
  `idstudent` INT NOT NULL,
  `nume` VARCHAR(45) NULL,
  `cnp` VARCHAR(45) NULL,
  `adresa` VARCHAR(45) NULL,
  `userName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`idstudent`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project1`.`StudentProfile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project1`.`StudentProfile` (
  `idStudentProfile` INT NOT NULL,
  `grupa` INT NULL,
  `student_idstudent` INT NOT NULL,
  PRIMARY KEY (`idStudentProfile`),
  INDEX `fk_StudentProfile_student_idx` (`student_idstudent` ASC),
  CONSTRAINT `fk_StudentProfile_student`
    FOREIGN KEY (`student_idstudent`)
    REFERENCES `project1`.`student` (`idstudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project1`.`Curs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project1`.`Curs` (
  `idCurs` INT NOT NULL,
  `nume` VARCHAR(45) NULL,
  `startTime` INT NULL,
  `endTime` INT NULL,
  `year` INT NULL,
  `semester` INT NULL,
  PRIMARY KEY (`idCurs`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project1`.`StudentProfile_has_Curs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `project1`.`StudentProfile_has_Curs` (
  `idStudentProfile` INT NOT NULL,
  `idCurs` INT NOT NULL,
  `notaPartial` INT NULL,
  `notaColocviu` INT NULL,
  `notaExamen` INT NULL,
  PRIMARY KEY (`idStudentProfile`, `idCurs`),
  INDEX `fk_StudentProfile_has_Curs_Curs1_idx` (`idCurs` ASC),
  INDEX `fk_StudentProfile_has_Curs_StudentProfile1_idx` (`idStudentProfile` ASC),
  CONSTRAINT `fk_StudentProfile_has_Curs_StudentProfile1`
    FOREIGN KEY (`idStudentProfile`)
    REFERENCES `project1`.`StudentProfile` (`idStudentProfile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_StudentProfile_has_Curs_Curs1`
    FOREIGN KEY (`idCurs`)
    REFERENCES `project1`.`Curs` (`idCurs`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

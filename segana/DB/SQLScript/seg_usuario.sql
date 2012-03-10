SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`seg_usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`seg_usuario` (
  `usr_usuario` INT NOT NULL ,
  `usr_nombre` VARCHAR(100) NOT NULL ,
  `usr_email` VARCHAR(100) NOT NULL ,
  `usr_fecha_nac` VARCHAR(10) NOT NULL ,
  `usr_password` VARCHAR(100) NOT NULL ,
  `usr_direccion` VARCHAR(100) NULL ,
  `usr_tarjeta` VARCHAR(100) NULL ,
  PRIMARY KEY (`usr_usuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`seg_tarjeta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`seg_tarjeta` (
  `taj_usuario` INT NOT NULL ,
  `taj_tarjeta` INT NOT NULL ,
  `taj_descripcion` VARCHAR(100) NOT NULL ,
  `taj_fecha_vence` VARCHAR(10) NULL ,
  `taj_nombre` VARCHAR(100) NULL ,
  PRIMARY KEY (`taj_usuario`, `taj_tarjeta`) ,
  INDEX `fk_usr_usuario` (`taj_usuario` ASC) ,
  CONSTRAINT `fk_usr_usuario`
    FOREIGN KEY (`taj_usuario` )
    REFERENCES `mydb`.`seg_usuario` (`usr_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`seg_rol`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`seg_rol` (
  `rol_rol` INT NOT NULL ,
  `rol_descripcion` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`rol_rol`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`seg_rol_usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`seg_rol_usuario` (
  `rus_usuario` INT NOT NULL ,
  `rus_rol` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`rus_usuario`, `rus_rol`) ,
  INDEX `fk_usr_usuario` (`rus_usuario` ASC) ,
  INDEX `fk_seg_rol_usuario_seg_rol1` (`rus_rol` ASC) ,
  CONSTRAINT `fk_usr_usuario`
    FOREIGN KEY (`rus_usuario` )
    REFERENCES `mydb`.`seg_usuario` (`usr_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seg_rol_usuario_seg_rol1`
    FOREIGN KEY (`rus_rol` )
    REFERENCES `mydb`.`seg_rol` (`rol_rol` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`seg_modulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`seg_modulo` (
  `mod_modulo` INT NOT NULL ,
  `descripcion` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`mod_modulo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`seg_opcion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`seg_opcion` (
  `opc_opcion` INT NOT NULL ,
  `opc_modulo` INT NOT NULL ,
  `opc_titulo` VARCHAR(100) NOT NULL ,
  `opc_descripcion` VARCHAR(100) NOT NULL ,
  `opc_link` VARCHAR(100) NOT NULL ,
  `opc_orden` INT NULL ,
  PRIMARY KEY (`opc_opcion`, `opc_modulo`) ,
  INDEX `fk_seg_opcion_seg_modulo1` (`opc_modulo` ASC) ,
  CONSTRAINT `fk_seg_opcion_seg_modulo1`
    FOREIGN KEY (`opc_modulo` )
    REFERENCES `mydb`.`seg_modulo` (`mod_modulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`seg_rol_opcion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`seg_rol_opcion` (
  `rop_rol` INT NOT NULL ,
  `rop_opcion` INT NOT NULL ,
  PRIMARY KEY (`rop_rol`, `rop_opcion`) ,
  INDEX `fk_seg_rol_opcion_seg_rol1` (`rop_rol` ASC) ,
  INDEX `fk_seg_rol_opcion_seg_opcion1` (`rop_opcion` ASC) ,
  CONSTRAINT `fk_seg_rol_opcion_seg_rol1`
    FOREIGN KEY (`rop_rol` )
    REFERENCES `mydb`.`seg_rol` (`rol_rol` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_seg_rol_opcion_seg_opcion1`
    FOREIGN KEY (`rop_opcion` )
    REFERENCES `mydb`.`seg_opcion` (`opc_opcion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dep_deporte`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`dep_deporte` (
  `dep_deporte` INT NOT NULL ,
  `dep_nombre` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`dep_deporte`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dep_edicion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`dep_edicion` (
  `edi_deporte` INT NOT NULL ,
  `edi_torneo` INT NOT NULL ,
  `edi_edicion` INT NOT NULL ,
  `edi_descripcion` VARCHAR(100) NULL ,
  PRIMARY KEY (`edi_torneo`, `edi_edicion`, `edi_deporte`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dep_torneo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`dep_torneo` (
  `tor_deporte` INT NOT NULL ,
  `tor_torneo` INT NOT NULL ,
  `tor_nombre` VARCHAR(100) NOT NULL ,
  `tor_numero_equipos` INT NULL ,
  PRIMARY KEY (`tor_deporte`, `tor_torneo`) ,
  INDEX `fk_dep_torneo_dep_deporte1` (`tor_deporte` ASC) ,
  INDEX `fk_dep_torneo_dep_torneo1` (`tor_deporte` ASC, `tor_torneo` ASC) ,
  CONSTRAINT `fk_dep_torneo_dep_deporte1`
    FOREIGN KEY (`tor_deporte` )
    REFERENCES `mydb`.`dep_deporte` (`dep_deporte` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dep_torneo_dep_torneo1`
    FOREIGN KEY (`tor_deporte` , `tor_torneo` )
    REFERENCES `mydb`.`dep_edicion` (`edi_deporte` , `edi_torneo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dep_equipo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`dep_equipo` (
  `dep_equipo` INT NOT NULL ,
  `Nombre` VARCHAR(100) NOT NULL ,
  `Ranking` INT NULL ,
  `fecha_fundacion` VARCHAR(10) NULL ,
  PRIMARY KEY (`dep_equipo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dep_participacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`dep_participacion` (
  `par_deporte` INT NOT NULL ,
  `par_torneo` INT NOT NULL ,
  `par_edicion` INT NOT NULL ,
  `par_equipo` INT NOT NULL ,
  `dep_equipo_dep_equipo` INT NOT NULL ,
  PRIMARY KEY (`par_equipo`, `par_edicion`, `par_deporte`, `par_torneo`, `dep_equipo_dep_equipo`) ,
  INDEX `fk_dep_participacion_dep_torneo1` (`par_edicion` ASC, `par_deporte` ASC, `par_torneo` ASC) ,
  INDEX `fk_dep_participacion_dep_equipo1` (`dep_equipo_dep_equipo` ASC) ,
  CONSTRAINT `fk_dep_participacion_dep_torneo1`
    FOREIGN KEY (`par_edicion` , `par_deporte` , `par_torneo` )
    REFERENCES `mydb`.`dep_edicion` (`edi_deporte` , `edi_torneo` , `edi_edicion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dep_participacion_dep_equipo1`
    FOREIGN KEY (`dep_equipo_dep_equipo` )
    REFERENCES `mydb`.`dep_equipo` (`dep_equipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`apu_encuentro`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`apu_encuentro` (
  `enc_encuentro` INT NOT NULL ,
  `enc_deporte` INT NOT NULL ,
  `enc_torneo` INT NOT NULL ,
  `enc_edicion` INT NOT NULL ,
  `enc_local` INT NOT NULL ,
  `enc_visita` INT NOT NULL ,
  `enc_escenario` VARCHAR(100) NOT NULL ,
  `enc_fecha_encuentro` VARCHAR(100) NOT NULL ,
  `enc_importe` FLOAT NOT NULL ,
  PRIMARY KEY (`enc_encuentro`) ,
  INDEX `fk_apu_encuentro_dep_equipo1` (`enc_local` ASC) ,
  INDEX `fk_apu_encuentro_dep_equipo2` (`enc_visita` ASC) ,
  INDEX `fk_apu_encuentro_dep_edicion1` (`enc_deporte` ASC, `enc_torneo` ASC, `enc_edicion` ASC) ,
  CONSTRAINT `fk_apu_encuentro_dep_equipo1`
    FOREIGN KEY (`enc_local` )
    REFERENCES `mydb`.`dep_equipo` (`dep_equipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_apu_encuentro_dep_equipo2`
    FOREIGN KEY (`enc_visita` )
    REFERENCES `mydb`.`dep_equipo` (`dep_equipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_apu_encuentro_dep_edicion1`
    FOREIGN KEY (`enc_deporte` , `enc_torneo` , `enc_edicion` )
    REFERENCES `mydb`.`dep_edicion` (`edi_deporte` , `edi_torneo` , `edi_edicion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`apu_apuesta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`apu_apuesta` (
  `apu_encuentro` INT NOT NULL ,
  `apu_apuesta` INT NOT NULL ,
  `apu_apostador` INT NOT NULL ,
  `apu_monto` FLOAT NOT NULL ,
  PRIMARY KEY (`apu_apuesta`, `apu_encuentro`) ,
  INDEX `fk_apu_apuesta_seg_usuario1` (`apu_apostador` ASC) ,
  INDEX `fk_apu_apuesta_apu_encuentro1` (`apu_encuentro` ASC) ,
  CONSTRAINT `fk_apu_apuesta_seg_usuario1`
    FOREIGN KEY (`apu_apostador` )
    REFERENCES `mydb`.`seg_usuario` (`usr_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_apu_apuesta_apu_encuentro1`
    FOREIGN KEY (`apu_encuentro` )
    REFERENCES `mydb`.`apu_encuentro` (`enc_encuentro` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`apu_pronostico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`apu_pronostico` (
  `apu_apuesta` INT NOT NULL ,
  `apu_encuentro` INT NOT NULL ,
  `apu_equipo` INT NOT NULL ,
  `valor` INT NULL ,
  PRIMARY KEY (`apu_apuesta`, `apu_encuentro`, `apu_equipo`) ,
  INDEX `fk_apu_pronostico_dep_equipo1` (`apu_equipo` ASC) ,
  INDEX `fk_apu_pronostico_apu_apuesta1` (`apu_apuesta` ASC, `apu_encuentro` ASC) ,
  CONSTRAINT `fk_apu_pronostico_dep_equipo1`
    FOREIGN KEY (`apu_equipo` )
    REFERENCES `mydb`.`dep_equipo` (`dep_equipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_apu_pronostico_apu_apuesta1`
    FOREIGN KEY (`apu_apuesta` , `apu_encuentro` )
    REFERENCES `mydb`.`apu_apuesta` (`apu_encuentro` , `apu_apuesta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

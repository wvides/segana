SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `gana` ;
USE `gana` ;

-- -----------------------------------------------------
-- Table `gana`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(250) NULL ,
  `email` VARCHAR(200) NULL ,
  `fecha_nac` DATE NULL ,
  `password` VARCHAR(45) NULL ,
  `direccion` VARCHAR(150) NULL ,
  `tarjeta` VARCHAR(100) NULL ,
  PRIMARY KEY (`idusuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`rol`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`rol` (
  `idrol` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idrol`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`rolusuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`rolusuario` (
  `idrolusuario` INT NOT NULL AUTO_INCREMENT ,
  `usuario_idusuario` INT NOT NULL ,
  `rol_idrol` INT NOT NULL ,
  PRIMARY KEY (`idrolusuario`) ,
  INDEX `fk_rolusuario_usuario1` (`usuario_idusuario` ASC) ,
  INDEX `fk_rolusuario_rol1` (`rol_idrol` ASC) ,
  CONSTRAINT `fk_rolusuario_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `gana`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rolusuario_rol1`
    FOREIGN KEY (`rol_idrol` )
    REFERENCES `gana`.`rol` (`idrol` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`tarjeta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`tarjeta` (
  `idtarjeta` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(145) NULL ,
  `fecha_vence` DATE NULL ,
  `nombre` VARCHAR(75) NULL ,
  `usuario_idusuario` INT NOT NULL ,
  PRIMARY KEY (`idtarjeta`) ,
  INDEX `fk_tarjeta_usuario` (`usuario_idusuario` ASC) ,
  CONSTRAINT `fk_tarjeta_usuario`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `gana`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`modulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`modulo` (
  `idmodulo` INT NOT NULL AUTO_INCREMENT ,
  `descrpipcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idmodulo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`opcion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`opcion` (
  `idopcion` INT NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(45) NULL ,
  `descripcion` VARCHAR(245) NULL ,
  `link` VARCHAR(345) NULL ,
  `orden` INT NULL ,
  `modulo_idmodulo` INT NOT NULL ,
  PRIMARY KEY (`idopcion`) ,
  INDEX `fk_opcion_modulo1` (`modulo_idmodulo` ASC) ,
  CONSTRAINT `fk_opcion_modulo1`
    FOREIGN KEY (`modulo_idmodulo` )
    REFERENCES `gana`.`modulo` (`idmodulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`acesso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`acesso` (
  `idacesso` INT NOT NULL AUTO_INCREMENT ,
  `rol_idrol` INT NOT NULL ,
  `opcion_idopcion` INT NOT NULL ,
  PRIMARY KEY (`idacesso`) ,
  INDEX `fk_acesso_rol1` (`rol_idrol` ASC) ,
  INDEX `fk_acesso_opcion1` (`opcion_idopcion` ASC) ,
  CONSTRAINT `fk_acesso_rol1`
    FOREIGN KEY (`rol_idrol` )
    REFERENCES `gana`.`rol` (`idrol` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acesso_opcion1`
    FOREIGN KEY (`opcion_idopcion` )
    REFERENCES `gana`.`opcion` (`idopcion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`deporte`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`deporte` (
  `iddeporte` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(75) NULL ,
  PRIMARY KEY (`iddeporte`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`torneo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`torneo` (
  `idtorneo` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(150) NULL ,
  `edicion_idedicion` INT NOT NULL ,
  `deporte_iddeporte` INT NOT NULL ,
  PRIMARY KEY (`idtorneo`) ,
  INDEX `fk_torneo_deporte1` (`deporte_iddeporte` ASC) ,
  CONSTRAINT `fk_torneo_deporte1`
    FOREIGN KEY (`deporte_iddeporte` )
    REFERENCES `gana`.`deporte` (`iddeporte` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`equipo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`equipo` (
  `idequipo` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(150) NULL ,
  `rankin` INT NULL ,
  `fundacion` DATE NULL ,
  PRIMARY KEY (`idequipo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`edicion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`edicion` (
  `idedicion` INT NOT NULL AUTO_INCREMENT ,
  `anio` DATE NULL ,
  `torneo_idtorneo` INT NOT NULL ,
  PRIMARY KEY (`idedicion`) ,
  INDEX `fk_edicion_torneo1` (`torneo_idtorneo` ASC) ,
  CONSTRAINT `fk_edicion_torneo1`
    FOREIGN KEY (`torneo_idtorneo` )
    REFERENCES `gana`.`torneo` (`idtorneo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`participacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`participacion` (
  `idparticipacion` INT NOT NULL AUTO_INCREMENT ,
  `equipo_idequipo` INT NOT NULL ,
  `edicion_idedicion` INT NOT NULL ,
  PRIMARY KEY (`idparticipacion`) ,
  INDEX `fk_participacion_equipo1` (`equipo_idequipo` ASC) ,
  INDEX `fk_participacion_edicion1` (`edicion_idedicion` ASC) ,
  CONSTRAINT `fk_participacion_equipo1`
    FOREIGN KEY (`equipo_idequipo` )
    REFERENCES `gana`.`equipo` (`idequipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participacion_edicion1`
    FOREIGN KEY (`edicion_idedicion` )
    REFERENCES `gana`.`edicion` (`idedicion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`encuentro`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`encuentro` (
  `idencuentro` INT NOT NULL AUTO_INCREMENT ,
  `escenario` VARCHAR(150) NULL ,
  `fecha` DATE NULL ,
  `edicion_idedicion` INT NOT NULL ,
  `equipo_idequipo` INT NOT NULL ,
  `equipo_idequipo1` INT NOT NULL ,
  PRIMARY KEY (`idencuentro`) ,
  INDEX `fk_encuentro_edicion1` (`edicion_idedicion` ASC) ,
  INDEX `fk_encuentro_equipo1` (`equipo_idequipo` ASC) ,
  INDEX `fk_encuentro_equipo2` (`equipo_idequipo1` ASC) ,
  CONSTRAINT `fk_encuentro_edicion1`
    FOREIGN KEY (`edicion_idedicion` )
    REFERENCES `gana`.`edicion` (`idedicion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_encuentro_equipo1`
    FOREIGN KEY (`equipo_idequipo` )
    REFERENCES `gana`.`equipo` (`idequipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_encuentro_equipo2`
    FOREIGN KEY (`equipo_idequipo1` )
    REFERENCES `gana`.`equipo` (`idequipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`apuesta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`apuesta` (
  `idapuesta` INT NOT NULL AUTO_INCREMENT ,
  `monto` DECIMAL(20,2) NULL ,
  `usuario_idusuario` INT NOT NULL ,
  `encuentro_idencuentro` INT NOT NULL ,
  PRIMARY KEY (`idapuesta`) ,
  INDEX `fk_apuesta_usuario1` (`usuario_idusuario` ASC) ,
  INDEX `fk_apuesta_encuentro1` (`encuentro_idencuentro` ASC) ,
  CONSTRAINT `fk_apuesta_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `gana`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_apuesta_encuentro1`
    FOREIGN KEY (`encuentro_idencuentro` )
    REFERENCES `gana`.`encuentro` (`idencuentro` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`pronostico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`pronostico` (
  `idpronostico` INT NOT NULL AUTO_INCREMENT ,
  `valor` INT NULL ,
  `apuesta_idapuesta` INT NOT NULL ,
  `equipo_idequipo` INT NOT NULL ,
  PRIMARY KEY (`idpronostico`) ,
  INDEX `fk_pronostico_apuesta1` (`apuesta_idapuesta` ASC) ,
  INDEX `fk_pronostico_equipo1` (`equipo_idequipo` ASC) ,
  CONSTRAINT `fk_pronostico_apuesta1`
    FOREIGN KEY (`apuesta_idapuesta` )
    REFERENCES `gana`.`apuesta` (`idapuesta` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pronostico_equipo1`
    FOREIGN KEY (`equipo_idequipo` )
    REFERENCES `gana`.`equipo` (`idequipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into rol(descripcion) values('admin');
insert into rol(descripcion) values('moderador');
insert into rol(descripcion) values('corredor');
insert into rol(descripcion) values('cliente');
insert into usuario(nombre,email,fecha_nac,password,direccion,tarjeta) values('admin','admin@admin.com','1985/1/1', '123','guatemala','00000');
insert into rolusuario(usuario_idusuario,rol_idrol) values(1,1);


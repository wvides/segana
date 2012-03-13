SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `gana` ;
USE `gana` ;

-- -----------------------------------------------------
-- Table `gana`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`usuario` (
  `idusuario` INT NOT NULL ,
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
  `idrol` INT NOT NULL ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idrol`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`rolusuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`rolusuario` (
  `idrolusuario` INT NOT NULL ,
  `usuario_idusuario` INT NOT NULL ,
  `rol_idrol` INT NOT NULL ,
  PRIMARY KEY (`idrolusuario`) ,
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

CREATE INDEX `fk_rolusuario_usuario1` ON `gana`.`rolusuario` (`usuario_idusuario` ASC) ;

CREATE INDEX `fk_rolusuario_rol1` ON `gana`.`rolusuario` (`rol_idrol` ASC) ;


-- -----------------------------------------------------
-- Table `gana`.`tarjeta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`tarjeta` (
  `idtarjeta` INT NOT NULL ,
  `descripcion` VARCHAR(145) NULL ,
  `fecha_vence` DATE NULL ,
  `nombre` VARCHAR(75) NULL ,
  `usuario_idusuario` INT NOT NULL ,
  PRIMARY KEY (`idtarjeta`) ,
  CONSTRAINT `fk_tarjeta_usuario`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `gana`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_tarjeta_usuario` ON `gana`.`tarjeta` (`usuario_idusuario` ASC) ;


-- -----------------------------------------------------
-- Table `gana`.`modulo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`modulo` (
  `idmodulo` INT NOT NULL ,
  `descrpipcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idmodulo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`opcion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`opcion` (
  `idopcion` INT NOT NULL ,
  `titulo` VARCHAR(45) NULL ,
  `descripcion` VARCHAR(245) NULL ,
  `link` VARCHAR(345) NULL ,
  `orden` INT NULL ,
  `modulo_idmodulo` INT NOT NULL ,
  PRIMARY KEY (`idopcion`) ,
  CONSTRAINT `fk_opcion_modulo1`
    FOREIGN KEY (`modulo_idmodulo` )
    REFERENCES `gana`.`modulo` (`idmodulo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_opcion_modulo1` ON `gana`.`opcion` (`modulo_idmodulo` ASC) ;


-- -----------------------------------------------------
-- Table `gana`.`acesso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`acesso` (
  `idacesso` INT NOT NULL ,
  `rol_idrol` INT NOT NULL ,
  `opcion_idopcion` INT NOT NULL ,
  PRIMARY KEY (`idacesso`) ,
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

CREATE INDEX `fk_acesso_rol1` ON `gana`.`acesso` (`rol_idrol` ASC) ;

CREATE INDEX `fk_acesso_opcion1` ON `gana`.`acesso` (`opcion_idopcion` ASC) ;


-- -----------------------------------------------------
-- Table `gana`.`deporte`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`deporte` (
  `iddeporte` INT NOT NULL ,
  `nombre` VARCHAR(75) NULL ,
  PRIMARY KEY (`iddeporte`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`torneo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`torneo` (
  `idtorneo` INT NOT NULL ,
  `nombre` VARCHAR(150) NULL ,
  `edicion_idedicion` INT NOT NULL ,
  `deporte_iddeporte` INT NOT NULL ,
  PRIMARY KEY (`idtorneo`, `deporte_iddeporte`) ,
  CONSTRAINT `fk_torneo_deporte1`
    FOREIGN KEY (`deporte_iddeporte` )
    REFERENCES `gana`.`deporte` (`iddeporte` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_torneo_deporte1` ON `gana`.`torneo` (`deporte_iddeporte` ASC) ;


-- -----------------------------------------------------
-- Table `gana`.`equipo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`equipo` (
  `idequipo` INT NOT NULL ,
  `nombre` VARCHAR(150) NULL ,
  `rankin` INT NULL ,
  `fundacion` DATE NULL ,
  PRIMARY KEY (`idequipo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gana`.`edicion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`edicion` (
  `idedicion` INT NOT NULL ,
  `anio` DATE NULL ,
  `torneo_idtorneo` INT NOT NULL ,
  PRIMARY KEY (`idedicion`) ,
  CONSTRAINT `fk_edicion_torneo1`
    FOREIGN KEY (`torneo_idtorneo` )
    REFERENCES `gana`.`torneo` (`idtorneo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_edicion_torneo1` ON `gana`.`edicion` (`torneo_idtorneo` ASC) ;


-- -----------------------------------------------------
-- Table `gana`.`participacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`participacion` (
  `idparticipacion` INT NOT NULL ,
  `equipo_idequipo` INT NOT NULL ,
  `edicion_idedicion` INT NOT NULL ,
  PRIMARY KEY (`idparticipacion`) ,
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

CREATE INDEX `fk_participacion_equipo1` ON `gana`.`participacion` (`equipo_idequipo` ASC) ;

CREATE INDEX `fk_participacion_edicion1` ON `gana`.`participacion` (`edicion_idedicion` ASC) ;


-- -----------------------------------------------------
-- Table `gana`.`encuentro`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`encuentro` (
  `idencuentro` INT NOT NULL ,
  `escenario` VARCHAR(150) NULL ,
  `fecha` DATE NULL ,
  `edicion_idedicion` INT NOT NULL ,
  `equipo_idequipo` INT NOT NULL ,
  `equipo_idequipo1` INT NOT NULL ,
  PRIMARY KEY (`idencuentro`) ,
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

CREATE INDEX `fk_encuentro_edicion1` ON `gana`.`encuentro` (`edicion_idedicion` ASC) ;

CREATE INDEX `fk_encuentro_equipo1` ON `gana`.`encuentro` (`equipo_idequipo` ASC) ;

CREATE INDEX `fk_encuentro_equipo2` ON `gana`.`encuentro` (`equipo_idequipo1` ASC) ;


-- -----------------------------------------------------
-- Table `gana`.`apuesta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`apuesta` (
  `idapuesta` INT NOT NULL ,
  `monto` DECIMAL(20,2) NULL ,
  `usuario_idusuario` INT NOT NULL ,
  `encuentro_idencuentro` INT NOT NULL ,
  `fantasy` BINARY NOT NULL ,
  PRIMARY KEY (`idapuesta`) ,
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

CREATE INDEX `fk_apuesta_usuario1` ON `gana`.`apuesta` (`usuario_idusuario` ASC) ;

CREATE INDEX `fk_apuesta_encuentro1` ON `gana`.`apuesta` (`encuentro_idencuentro` ASC) ;


-- -----------------------------------------------------
-- Table `gana`.`pronostico`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `gana`.`pronostico` (
  `idpronostico` INT NOT NULL ,
  `valor` INT NULL ,
  `apuesta_idapuesta` INT NOT NULL ,
  `equipo_idequipo` INT NOT NULL ,
  `pronosticocol` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idpronostico`) ,
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

CREATE INDEX `fk_pronostico_apuesta1` ON `gana`.`pronostico` (`apuesta_idapuesta` ASC) ;

CREATE INDEX `fk_pronostico_equipo1` ON `gana`.`pronostico` (`equipo_idequipo` ASC) ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

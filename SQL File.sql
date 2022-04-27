/* Primero crear la BD */

CREATE SCHEMA IF NOT EXISTS `cimsys`;
USE `cimsys`;

/* Ir a la netbeans y hacer clean & build project */
/* Revisar que las tablas sean creadas */


/* Agregar datos de pruebas */

CREATE TABLE IF NOT EXISTS `rol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rol_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `cimsys`.`rol`
(`rol_name`)VALUES("ADMIN");
INSERT INTO `cimsys`.`rol`
(`rol_name`)VALUES("USER");


CREATE TABLE IF NOT EXISTS `persona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `cedula` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `rol_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKagk94o14hgd6fooo73yv2u6us` (`rol_id`),
  CONSTRAINT `FKagk94o14hgd6fooo73yv2u6us` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
);


INSERT INTO `cimsys`.`persona`
(`nombre`,`apellidos`,`cedula`,`email`,`telefono`,`user_name`,`password`,`rol_id`)VALUES("Daniel","Murillo","C00","@","tel","admin","123", "1");
INSERT INTO `cimsys`.`persona`
(`nombre`,`apellidos`,`cedula`,`email`,`telefono`,`user_name`,`password`,`rol_id`)VALUES("empleado","","","@","tel","empleado","123", "2");
INSERT INTO `cimsys`.`persona`
(`nombre`,`apellidos`,`cedula`,`email`,`telefono`,`rol_id`)VALUES("Cliente","Amazon","C01","@","tel",2);



CREATE TABLE IF NOT EXISTS `caso` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT '0',
  `titulo` varchar(255) DEFAULT NULL,
  `fecha_inicio` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_resolucion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `resolucion` varchar(255) DEFAULT '0',
  `asignado_id` bigint DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc51pw2e2n08iigvdgco5oxjc0` (`asignado_id`),
  KEY `FKi5d7j193qg15nftffw405e3hd` (`cliente_id`),
  CONSTRAINT `FKc51pw2e2n08iigvdgco5oxjc0` FOREIGN KEY (`asignado_id`) REFERENCES `persona` (`id`),
  CONSTRAINT `FKi5d7j193qg15nftffw405e3hd` FOREIGN KEY (`cliente_id`) REFERENCES `persona` (`id`)
) ;

INSERT INTO `cimsys`.`caso`
(`codigo`,`cliente_id`,`asignado_id`,`titulo`,`descripcion`)VALUES("codigo-001","3","1","Compra 001","revision de Compra 001");
INSERT INTO `cimsys`.`caso`
(`codigo`,`cliente_id`,`asignado_id`,`titulo`,`descripcion`)VALUES("codigo-002","3","1","Compra 002","revision de Compra 002");
INSERT INTO `cimsys`.`caso`
(`codigo`,`cliente_id`,`asignado_id`,`titulo`,`descripcion`)VALUES("codigo-003","3","2","Compra 003","revision de Compra 003");


CREATE TABLE IF NOT EXISTS `comentario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comentario` varchar(255) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `caso_id` bigint DEFAULT NULL,
  `persona_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcevtgju75q3yint2w419hcdvd` (`caso_id`),
  KEY `FK5vo9ir7cpuka387k60heia9u9` (`persona_id`),
  CONSTRAINT `FK5vo9ir7cpuka387k60heia9u9` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`),
  CONSTRAINT `FKcevtgju75q3yint2w419hcdvd` FOREIGN KEY (`caso_id`) REFERENCES `caso` (`id`)
);


INSERT INTO `cimsys`.`comentario`
(`caso_id`,`persona_id`,`comentario`)VALUES("1","1","Comentario 1");
INSERT INTO `cimsys`.`comentario`
(`caso_id`,`persona_id`,`comentario`)VALUES("1","1","Comentario 2");



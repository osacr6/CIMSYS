/* Primero crear la BD */

CREATE SCHEMA `cimsys` ;

/* Ir a la netbeans y hacer clean & build project */
/* Revisar que las tablas sean creadas */


/* Agregar datos de pruebas */
INSERT INTO `cimsys`.`rol`
(`rol_name`)VALUES("ADMIN");

INSERT INTO `cimsys`.`usuario`
(`user_name`, `password`, `rol_id`)VALUES("admin","123", "1");

INSERT INTO `cimsys`.`persona`
(`nombre`,`apellidos`,`cedula`,`email`,`telefono`,`usuario_id`)VALUES("Daniel","Murillo","C00","@","tel",1);


INSERT INTO `cimsys`.`caso`
(`codigo`,`persona_id`,`titulo`,`descripcion`,`status`)VALUES("codigo-001","1","Compra 001","revision de Compra 001","OPEN");
INSERT INTO `cimsys`.`caso`
(`codigo`,`persona_id`,`titulo`,`descripcion`,`status`)VALUES("codigo-002","1","Compra 002","revision de Compra 002","OPEN");
INSERT INTO `cimsys`.`caso`
(`codigo`,`persona_id`,`titulo`,`descripcion`,`status`)VALUES("codigo-003","1","Compra 003","revision de Compra 003","OPEN");


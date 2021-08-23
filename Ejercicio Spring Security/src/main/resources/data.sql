DROP TABLE IF EXISTS `cientificos`;

CREATE TABLE `cientificos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB ;

INSERT INTO `cientificos` (nombre) VALUES ('Hola'),('Que'),('tal'),('Jose');



DROP TABLE IF EXISTS `proyectos`;
CREATE TABLE `proyectos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `horas` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO `proyectos` (nombre, horas) VALUES ('Yo',98),('Estoy',789),('Bastante',123),('Bien',56);

DROP TABLE IF EXISTS `asignado_a`;
CREATE TABLE `asignado_a` (
`id` int(11) not null  AUTO_INCREMENT,
  `cientifico` int(11) NOT NULL,
  `proyecto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `course_registration_FK` FOREIGN KEY (`id`) REFERENCES `cientificos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_registration_FK_1` FOREIGN KEY (`proyecto`) REFERENCES `proyectos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

INSERT INTO `asignado_a` (cientifico, proyecto) VALUES (1,1),(2,1),(3,1),(4,4);


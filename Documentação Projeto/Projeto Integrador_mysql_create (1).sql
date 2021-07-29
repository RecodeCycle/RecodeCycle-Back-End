CREATE TABLE `usuarios` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`usuario` varchar(100) NOT NULL,
	`senha` varchar(255) NOT NULL,
	`confirmacaoSenha` varchar(255) NOT NULL,
	`bios` varchar(255) NOT NULL,
	`telefone` varchar(255) NOT NULL,
	`recebaEmail` varchar(255) NOT NULL,
	`fotoPerfil` varchar(255) NOT NULL,
	`nivel` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `categoria` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`descricao` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `postagens` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`titulo` varchar(500) NOT NULL,
	`texto` varchar(5000) NOT NULL,
	`data` TIMESTAMP NOT NULL,
	`usuario_id` bigint NOT NULL,
	`categoria_id` bigint NOT NULL,
	`regioes` varchar(255) NOT NULL,
	`residuos` varchar(255) NOT NULL,
	`informativos` varchar(500) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `postagens` ADD CONSTRAINT `postagens_fk0` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios`(`id`);

ALTER TABLE `postagens` ADD CONSTRAINT `postagens_fk1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria`(`id`);





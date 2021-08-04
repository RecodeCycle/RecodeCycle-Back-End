CREATE TABLE [usuarios] (
	id bigint NOT NULL,
	nome varchar(100) NOT NULL,
	email varchar(50) NOT NULL,
	senha varchar NOT NULL,
	confirmacaoSenha varchar NOT NULL,
	biografia varchar(500) NOT NULL,
	telefone varchar(20) NOT NULL,
	recebaEmail varchar(255) NOT NULL,
	fotoPerfil varchar(255) NOT NULL,
	admin varchar(20) NOT NULL,
	nivel int NOT NULL,
  CONSTRAINT [PK_USUARIOS] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [categorias] (
	id bigint NOT NULL,
	descricao varchar(50) NOT NULL,
  CONSTRAINT [PK_CATEGORIAS] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [postagens] (
	id bigint NOT NULL,
	titulo varchar(500) NOT NULL,
	texto varchar(5000) NOT NULL,
	data timestamp NOT NULL,
	usuarios_id bigint NOT NULL,
	categorias_id bigint NOT NULL,
	regioes varchar(255) NOT NULL,
	residuos varchar(255) NOT NULL,
	informativos varchar(500) NOT NULL,
  CONSTRAINT [PK_POSTAGENS] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO


ALTER TABLE [postagens] WITH CHECK ADD CONSTRAINT [postagens_fk0] FOREIGN KEY ([usuarios_id]) REFERENCES [usuarios]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [postagens] CHECK CONSTRAINT [postagens_fk0]
GO
ALTER TABLE [postagens] WITH CHECK ADD CONSTRAINT [postagens_fk1] FOREIGN KEY ([categorias_id]) REFERENCES [categorias]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [postagens] CHECK CONSTRAINT [postagens_fk1]
GO
ALTER TABLE [postagens] WITH CHECK ADD CONSTRAINT [postagens_fk2] FOREIGN KEY ([regioes]) REFERENCES [categorias]([])
ON UPDATE CASCADE
GO
ALTER TABLE [postagens] CHECK CONSTRAINT [postagens_fk2]
GO
ALTER TABLE [postagens] WITH CHECK ADD CONSTRAINT [postagens_fk3] FOREIGN KEY ([residuos]) REFERENCES [categorias]([])
ON UPDATE CASCADE
GO
ALTER TABLE [postagens] CHECK CONSTRAINT [postagens_fk3]
GO
ALTER TABLE [postagens] WITH CHECK ADD CONSTRAINT [postagens_fk4] FOREIGN KEY ([informativos]) REFERENCES [categorias]([])
ON UPDATE CASCADE
GO
ALTER TABLE [postagens] CHECK CONSTRAINT [postagens_fk4]
GO


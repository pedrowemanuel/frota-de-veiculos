CREATE TABLE marca (
	id 			SERIAL	 		PRIMARY KEY,
	descricao 	VARCHAR(255) 	NOT NULL 	UNIQUE
);

CREATE TABLE marca_pneu (
	id			SERIAL 			PRIMARY KEY,
	descricao 	VARCHAR(255)	NOT NULL UNIQUE
);

CREATE TABLE tipo_eixo (
	id 			SERIAL 			PRIMARY KEY,
	descricao 	VARCHAR(255) 	NOT NULL 	UNIQUE
);

CREATE TABLE banda (
    id          SERIAL      	PRIMARY KEY,
    descricao   VARCHAR(45) 	UNIQUE		NOT NULL,
    lado     	VARCHAR(45) 	NOT NULL
);

CREATE TABLE veiculo (
	id 			SERIAL	 		PRIMARY KEY,
	descricao 	VARCHAR(255) 	NOT NULL 	UNIQUE,
	id_marca 	INT 			NOT NULL 	REFERENCES marca
);

CREATE TABLE eixo (
	id 				SERIAL	 		PRIMARY KEY,
	descricao 		VARCHAR(255) 	NOT NULL,
	posicao			INT				NOT NULL,
	id_tipo_eixo	INT 			NOT NULL 	REFERENCES tipo_eixo
);

CREATE TABLE pneu (
	id 					SERIAL 			PRIMARY KEY,
	raio 				INT 			NOT NULL,
	perfil 				VARCHAR(30) 	NOT NULL,
	largura 			VARCHAR(45) 	NOT NULL,
	altura 			    VARCHAR(45) 	NOT NULL,
	indice_carga		VARCHAR(45) 	NOT NULL,
	indice_velocidade	VARCHAR(45)		NOT NULL,
	id_marca_pneu		INT 			NOT NULL 	REFERENCES marca_pneu
);

CREATE TABLE pneu_reserva (
	id 			SERIAL	 	PRIMARY KEY,
	observacao	VARCHAR(255),
	id_veiculo	INT 		NOT NULL 	REFERENCES veiculo,
	id_pneu		INT 		NOT NULL 	REFERENCES pneu
);

CREATE TABLE eixo_veiculo (
	id 			SERIAL	 	PRIMARY KEY,
	id_veiculo	INT 		NOT NULL 	REFERENCES veiculo,
	id_eixo		INT 		NOT NULL 	REFERENCES eixo,
	id_pneu		INT 		NOT NULL 	REFERENCES pneu
);

CREATE TABLE vistoria_veiculo (
    id              SERIAL      PRIMARY KEY,
    observacao      VARCHAR(255),
    data_vistoria   TIMESTAMP   DEFAULT NULL,
    id_veiculo      INT         NOT NULL        REFERENCES veiculo,
    username        VARCHAR(45) NOT NULL
);

CREATE TABLE vistoria_pneu (
    id             	    SERIAL      PRIMARY KEY,
    data_cadastro  	    TIMESTAMP   NOT NULL,
    id_vistoria_veiculo INT         NOT NULL        REFERENCES vistoria_veiculo,
    username       	    VARCHAR(45) NOT NULL,
    id_pneu             INT         NOT NULL        REFERENCES pneu
);

CREATE TABLE medicao_vistoria  (
    id                          SERIAL          PRIMARY KEY,
    raio                        INT             NOT NULL,
    perfil                      VARCHAR(30)     NOT NULL,
    largura                     VARCHAR(45)     NOT NULL,
    altura                      VARCHAR(45)     NOT NULL,
    indice_carga                VARCHAR(45)     NOT NULL,
    indice_velocidade           VARCHAR(45)     NOT NULL,
    id_marca_pneu               INT             NOT NULL        REFERENCES marca_pneu,
    id_vistoria_pneu            INT             NOT NULL        REFERENCES vistoria_pneu           
);

CREATE TABLE pneu_banda (
    id          SERIAL     	    PRIMARY KEY,
    observacao  VARCHAR(45),
    id_pneu 	INT		        NOT NULL    REFERENCES pneu,
    ordem	    INT		        NOT NULL,
    id_banda    INT		        NOT NULL    REFERENCES banda
);

CREATE TABLE medicao_banda_vistoria (
    id                    SERIAL      PRIMARY KEY,
    valor                 FLOAT       NOT NULL,
    id_pneu_banda         INT         NOT NULL    REFERENCES pneu_banda,
    id_medicao_vistoria   INT         NOT NULL    REFERENCES medicao_vistoria
);

-- marca                        Marca.class                          MarcaDAO.java                     (Feito)
-- marca_pneu                   MarcaPneu.class                      MarcaPneuDAO.java                 (Feito)
-- tipo_eixo                    TipoEixo.class                       TipoEixoDAO.java                  (Feito)
-- banda                        Banda.class                          BandaDAO.java                     (Feito)
-- veiculo                      Veiculo.class                        VeiculoDAO.java                   (Feito)
-- eixo                         Eixo.class                           EixoDAO.java                      (Feito)
-- pneu                         Pneu.class                           PneuDAO.java                      (Feito)
-- pneu_reserva                 PneuReserva.class                    PneuReservaDAO.java               (Feito)
-- eixo_veiculo                 EixoVeiculo.class                    EixoVeiculoDAO.java               (Feito)
-- vistoria_veiculo             VistoriaVeiculo.class                VistoriaVeiculoDAO.java           (Feito)
-- vistoria_pneu                VistoriaPneu.class                   VistoriaPneuDAO.java              (Feito)
-- medicao_vistoria             MedicaoVistoria.class                MedicaoVistoriaDAO.java           (Feito)
-- pneu_banda                   PneuBanda.class                      PneuBandaDAO.java                 (Feito)
-- medicao_banda_vistoria       MedicaoBandaVistoria.class           MedicaoBandaVistoriaDAO.java      (Feito)

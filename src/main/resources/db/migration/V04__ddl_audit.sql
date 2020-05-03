CREATE SCHEMA audit;

CREATE SEQUENCE hibernate_sequence INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE audit.revinfo (
  rev INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  revtstmp BIGINT,
  CONSTRAINT pk_revinfo PRIMARY KEY (rev)
);

CREATE TABLE audit.usuario_aud (
  rev INTEGER NOT NULL,
  revtype SMALLINT,
  id SERIAL NOT NULL,
  nome VARCHAR(128),
  data_nascimento DATE,
  email VARCHAR(128),
  valor_senha VARCHAR(64),
  reset_token_senha VARCHAR(255),
  tentativas_erro_senha SMALLINT,
  data_atualizacao_senha DATE,
  pendente BOOLEAN,
  bloqueado BOOLEAN,
  ativo BOOLEAN,
  ativacao_token VARCHAR(255),
  created_at TIMESTAMP WITHOUT TIME ZONE,
  created_by VARCHAR(32),
  updated_at TIMESTAMP WITHOUT TIME ZONE,
  updated_by VARCHAR(32),
  CONSTRAINT pk_usuario_aud PRIMARY KEY (rev, id)
);

CREATE TABLE audit.grupo_aud (
  rev INTEGER NOT NULL,
  revtype SMALLINT,
  id SERIAL NOT NULL,
  nome VARCHAR(128),
  ativo BOOLEAN,
  created_at TIMESTAMP WITHOUT TIME ZONE,
  created_by VARCHAR(32),
  updated_at TIMESTAMP WITHOUT TIME ZONE,
  updated_by VARCHAR(32),
  CONSTRAINT pk_grupo_aud PRIMARY KEY (rev, id)
);

CREATE TABLE audit.grupo_permissao_aud (
  rev INTEGER NOT NULL,
  revtype SMALLINT,
  id_grupo INTEGER NOT NULL,
  id_permissao INTEGER NOT NULL,
  CONSTRAINT pk_grupo_permissao_aud PRIMARY KEY (rev, id_grupo, id_permissao)
);

CREATE TABLE audit.usuario_grupo_aud (
  rev INTEGER NOT NULL,
  revtype SMALLINT,
  id_usuario INTEGER NOT NULL,
  id_grupo INTEGER NOT NULL,
  CONSTRAINT pk_usuario_grupo_aud PRIMARY KEY (rev, id_usuario, id_grupo)
);

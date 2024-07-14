CREATE TABLE atribuicao_cartorio (
    id VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    situacao BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO atribuicao_cartorio (id, nome,situacao) VALUES ('ATRIB1', 'Atribuicao 1', true);
INSERT INTO atribuicao_cartorio (id, nome,situacao) VALUES ('ATRIB2', 'Atribuicao 2', true);
INSERT INTO atribuicao_cartorio (id, nome,situacao) VALUES ('ATRIB3', 'Atribuicao 3', true);
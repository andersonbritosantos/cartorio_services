CREATE TABLE cartorios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    observacao VARCHAR(250),
    situacao VARCHAR(20),
    atribuicao VARCHAR(20),
    CONSTRAINT fk_cartorio_situacao FOREIGN KEY(situacao) REFERENCES situacao_cartorio(id)
);

CREATE TABLE cartorio_atribuicao (
     cartorio_id INT,
     atribuicao_id VARCHAR(20),
     PRIMARY KEY (cartorio_id, atribuicao_id),
     CONSTRAINT fk_cartorio_atribuicao_cartorio FOREIGN KEY(cartorio_id) REFERENCES cartorios(id),
     CONSTRAINT fk_cartorio_atribuicao_atribuicao FOREIGN KEY(atribuicao_id) REFERENCES atribuicao_cartorio(id)
);
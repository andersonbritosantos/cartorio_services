package br.com.cartorios.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity(name="atribuicao_cartorio")
@Data
public class Atribuicao {
    @Id
    @Column(length = 20, nullable = false)
    @NotNull(message = "O ID da atribuição é obrigatório")
    private String id;

    @Column(length = 50, nullable = false)
    @NotNull(message = "O nome da atribuição é obrigatório")
    private String nome;

    @Column(columnDefinition = "boolean default true")
    @NotNull(message = "A situacao da atribuição é obrigatório")
    private boolean situacao = true;
}

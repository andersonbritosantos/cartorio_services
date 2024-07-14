package br.com.cartorios.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "situacao_cartorio")
@Data
public class Situacao {

    @Id
    @Column(length = 20)
    @NotNull(message = "O ID da atribuição é obrigatório")
    private String id;
    @Column(length = 50)
    @NotNull(message = "O nome da atribuição é obrigatório")
    private String nome;

}

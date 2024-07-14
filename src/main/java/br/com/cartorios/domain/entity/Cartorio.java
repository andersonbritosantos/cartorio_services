package br.com.cartorios.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cartorios")
@Data
public class Cartorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 150)
    @NotNull(message = "O nome da cartorio é obrigatório")
    private String nome;

    @Column(length = 250)
    private String observacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "situacao")
    @NotNull(message = "A situacao do cartorio é obrigatório")
    private Situacao situacao;

    @ManyToMany
    @JoinTable(
            name = "cartorio_atribuicao",
            joinColumns = @JoinColumn(name = "cartorio_id"),
            inverseJoinColumns = @JoinColumn(name = "atribuicao_id")
    )
    @NotEmpty(message = "Pelo menos uma atribuição deve ser especificada")
    private List<Atribuicao> atribuicao;
}

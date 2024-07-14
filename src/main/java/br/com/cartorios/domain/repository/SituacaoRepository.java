package br.com.cartorios.domain.repository;

import br.com.cartorios.domain.entity.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, String> {
        Optional<Situacao> findByNome(String nome);
}

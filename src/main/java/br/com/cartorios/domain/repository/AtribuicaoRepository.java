package br.com.cartorios.domain.repository;

import br.com.cartorios.domain.entity.Atribuicao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AtribuicaoRepository extends JpaRepository<Atribuicao, String> {
    @Query("SELECT c.id,c.nome FROM atribuicao_cartorio c")
    Page<Atribuicao> listarTodosIdNomePaginado(Pageable pageable);

    Optional<Atribuicao> findByNome(String nome);
}

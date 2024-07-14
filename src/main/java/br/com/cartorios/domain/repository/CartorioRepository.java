package br.com.cartorios.domain.repository;

import br.com.cartorios.domain.entity.Cartorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {

    @Query("SELECT c.id, c.nome FROM Cartorio c") // Exemplo simples de consulta
    Page<Cartorio> listarTodosPaginado(Pageable pageable);

    Optional<Cartorio> findByNome(String nome);

}

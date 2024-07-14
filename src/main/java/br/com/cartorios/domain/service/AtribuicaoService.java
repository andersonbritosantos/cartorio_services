package br.com.cartorios.domain.service;

import br.com.cartorios.domain.entity.Atribuicao;
import br.com.cartorios.domain.repository.AtribuicaoRepository;
import br.com.cartorios.exception.APIException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AtribuicaoService {
    private final AtribuicaoRepository repository;

    public List<Atribuicao> listarTodos(){
        return repository.findAll();
    }

    public Page<Atribuicao> listarTodosIdNomePaginado(int pagina) {
        Pageable pageable = PageRequest.of(pagina, 10);
        return repository.listarTodosIdNomePaginado(pageable);
    }

    public Atribuicao save(Atribuicao atribuicao){
        validarSave(atribuicao);
        return repository.save(atribuicao);

    }

    public void validarSave(Atribuicao atribuicao){
        Optional<Atribuicao> nome = repository.findByNome(atribuicao.getNome());
        Optional<Atribuicao> id = repository.findById(atribuicao.getId());

        if (nome.isPresent()){
            throw new APIException("Nome já informado no registro com código "+nome.get().getId());
        }
        if (id.isPresent()){
            throw new APIException("Registro já cadastrado");
        }
    }

    public Optional<Atribuicao> listarPorId(String id){
        return repository.findById(id);
    }

    public Atribuicao update(String id,Atribuicao atribuicao){
        Optional<Atribuicao> atribuicaoUpdate = this.listarPorId(id);
        Optional<Atribuicao> nome = repository.findByNome(atribuicao.getNome());
        if (atribuicaoUpdate.isEmpty()){
            throw new APIException("Atribuicao não Cadastrado");
        }
        if (nome.isPresent()){
            throw new APIException("Nome já informado no registro com código "+nome.get().getId());
        }
        atribuicao.setId(id);
        return repository.save(atribuicao);

    }

    public void delete(String id){

    }
}

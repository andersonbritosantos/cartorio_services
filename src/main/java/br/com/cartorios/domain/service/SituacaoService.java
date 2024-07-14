package br.com.cartorios.domain.service;

import br.com.cartorios.domain.entity.Cartorio;
import br.com.cartorios.domain.entity.Situacao;
import br.com.cartorios.domain.repository.CartorioRepository;
import br.com.cartorios.domain.repository.SituacaoRepository;
import br.com.cartorios.exception.APIException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class SituacaoService {
    private final SituacaoRepository repository;

    public List<Situacao> listarTodos(){
        return repository.findAll();
    }

    public Situacao save(Situacao situacao){
        validarSave(situacao);
        return repository.save(situacao);
    }

    public void validarSave(Situacao situacao){
        Optional<Situacao> nome = repository.findByNome(situacao.getNome());
        Optional<Situacao> id = repository.findById(situacao.getId());

        if (nome.isPresent()){
            throw new APIException("Nome já informado no registro com código "+nome.get().getId());
        }
        if (id.isPresent()){
            throw new APIException("Registro já cadastrado");
        }

    }


    public Optional<Situacao> listarPorId(String id){
        return repository.findById(id);
    }

    public Situacao update(String id,Situacao situacao){
        Optional<Situacao> situacaoUpdate = this.listarPorId(id);
        Optional<Situacao> nome = repository.findByNome(situacao.getNome());
        if (situacaoUpdate.isEmpty()){
            throw new APIException("Situacao não Cadastrado");
        }
        if (nome.isPresent()){
            throw new APIException("Nome já informado no registro com código "+nome.get().getId());
        }
        situacao.setId(id);
        return repository.save(situacao);
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}

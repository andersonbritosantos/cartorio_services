package br.com.cartorios.domain.service;


import br.com.cartorios.domain.entity.Cartorio;
import br.com.cartorios.domain.repository.CartorioRepository;
import br.com.cartorios.domain.repository.SituacaoRepository;
import br.com.cartorios.exception.APIException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartorioService {
    private final CartorioRepository repository;

    public List<Cartorio> listarTodos(){
        return repository.findAll();
    }

    public Page<Cartorio> listarCartoriosPaginado(Pageable pageable) {
        return repository.listarTodosPaginado(pageable);
    }

    public Cartorio save(Cartorio cartorio){
        validarSave(cartorio);
        Optional<Cartorio> id = repository.findById(cartorio.getId());
        return repository.save(cartorio);
    }

    public void validarSave(Cartorio cartorio){
        Optional<Cartorio> nome = repository.findByNome(cartorio.getNome());
        Optional<Cartorio> id = repository.findById(cartorio.getId());

        if (nome.isPresent()){
            throw new APIException("Nome já informado no registro com código "+nome.get().getId());
        }
        if (id.isPresent()) {
            throw new APIException("Registro já cadastrado");
        }

    }

    public Optional<Cartorio> listarPorId(int id){
        return repository.findById(id);
    }

    public Cartorio update(int id, Cartorio cartorio){
        Optional<Cartorio> cartorioUpdate = this.listarPorId(id);
        Optional<Cartorio> nome = repository.findByNome(cartorio.getNome());
        if (cartorioUpdate.isEmpty()){
            throw new APIException("Cartorio não Cadastrado");
        }
        if (nome.isPresent()){
            throw new APIException("Nome já informado no registro com código "+nome.get().getId());
        }
        cartorio.setId(id);
        return repository.save(cartorio);

    }

    public void delete(int id){
        repository.deleteById(id);
    }

}

package br.com.cartorios.api;

import br.com.cartorios.domain.entity.Situacao;
import br.com.cartorios.domain.service.SituacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/situacao")
public class SituacaoController {
    private final SituacaoService service;

    @PostMapping
    public ResponseEntity<Situacao> salvar(@RequestBody Situacao situacao){
        Situacao save = service.save(situacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Situacao> alterar(@PathVariable String id, @RequestBody Situacao situacao){
        Situacao cartorioSave = service.update(id,situacao);
        return ResponseEntity.status(HttpStatus.OK).body(cartorioSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Situacao> deletar(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping
    public ResponseEntity<List<Situacao>> listarTodos(){
        List<Situacao> situacoes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(situacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Situacao> listarPorId(@PathVariable String id) {
        Optional<Situacao> situacao = service.listarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(situacao.get());
    }

}

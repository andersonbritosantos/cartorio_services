package br.com.cartorios.api;

import br.com.cartorios.domain.entity.Atribuicao;
import br.com.cartorios.domain.service.AtribuicaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/atribuicao")
public class AtribuicaoController {
    private final AtribuicaoService service;
    @PostMapping
    public ResponseEntity<Atribuicao> salvar(@RequestBody Atribuicao atribuicao){
        Atribuicao save = service.save(atribuicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atribuicao> alterar(@PathVariable String id, @RequestBody Atribuicao atribuicao){
        Atribuicao atribuicaoSave = service.update(id,atribuicao);
        return ResponseEntity.status(HttpStatus.OK).body(atribuicaoSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Atribuicao> deletar(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping
    public ResponseEntity<List<Atribuicao>> listarTodos(){
        List<Atribuicao> atribuicoes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(atribuicoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atribuicao> listarPorId(@PathVariable String id) {
        Optional<Atribuicao> atribuicao = service.listarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(atribuicao.get());
    }
}

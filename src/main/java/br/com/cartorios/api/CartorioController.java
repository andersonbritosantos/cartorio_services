package br.com.cartorios.api;

import br.com.cartorios.domain.entity.Cartorio;
import br.com.cartorios.domain.entity.Situacao;
import br.com.cartorios.domain.service.CartorioService;
import br.com.cartorios.exception.APIException;
import jakarta.validation.OverridesAttribute;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cartorio")

public class CartorioController {
    private final CartorioService service;

    @PostMapping
    public ResponseEntity<Cartorio> salvar(@RequestBody Cartorio cartorio){
        Cartorio cartorioSave = service.save(cartorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartorioSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cartorio> alterar(@PathVariable int id, @RequestBody Cartorio cartorio){
        Cartorio cartorioSave = service.update(id,cartorio);
        return ResponseEntity.status(HttpStatus.OK).body(cartorioSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cartorio> deletar(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
        public ResponseEntity<Cartorio> listarPorId(@PathVariable int id) {
        Optional<Cartorio> cartorio = service.listarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(cartorio.get());
    }

    @GetMapping("/listarIdNomePag")
    public ResponseEntity<Page<Cartorio>> listarCartoriosIdNomePaginado(@RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Cartorio> cartoriosPage = service.listarCartoriosPaginado(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(cartoriosPage);
    }

    @RequestMapping
    public ResponseEntity<List<Cartorio>> listarTodos(){
        List<Cartorio> cartorios = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(cartorios);
    }


}

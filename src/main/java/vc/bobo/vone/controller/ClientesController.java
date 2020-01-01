package vc.bobo.vone.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vc.bobo.vone.model.Tbclientes;
import vc.bobo.vone.repository.ClientesRepository;


@RestController
@RequestMapping({"/clientes"})
public class ClientesController {
    
     private ClientesRepository repository;
    
     ClientesController(ClientesRepository clientesRepository) {
        this.repository = clientesRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Tbclientes> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public void create(@RequestBody Tbclientes clientes) {
        repository.save(clientes);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    private void orElse(ResponseEntity<Object> build) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

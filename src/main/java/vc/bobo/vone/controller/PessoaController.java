package vc.bobo.vone.controller;

import vc.bobo.vone.model.Tbpessoa;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vc.bobo.vone.repository.PessoaRepository;

@RestController
@RequestMapping({"/pessoas"})
public class PessoaController {

    private PessoaRepository repository;

    PessoaController(PessoaRepository pessoaRepository) {
        this.repository = pessoaRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Tbpessoa> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public void create(@RequestBody Tbpessoa pessoa) {
        repository.save(pessoa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Tbpessoa pessoa) {
        return repository.findById(id)
                .map(record -> {
                    record.setNOME(pessoa.getNOME());
                    record.setEMAIL(pessoa.getEMAIL());
                    record.setTELEFONE(pessoa.getTELEFONE());
                    record.setCPF(pessoa.getCPF());
                    record.setFJ(pessoa.getFJ());
                    record.setIDPESSOA(pessoa.getIDPESSOA());
                    record.setRG(pessoa.getRG());
                    record.setSEXO(pessoa.getSEXO());
                    Tbpessoa updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
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

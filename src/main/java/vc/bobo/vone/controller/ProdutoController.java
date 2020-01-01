package vc.bobo.vone.controller;

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
import vc.bobo.vone.model.Tbproduto;
import vc.bobo.vone.repository.ProdutoRepository;

@RestController
@RequestMapping({"/produto"})
public class ProdutoController {
    
    private ProdutoRepository repository;
    
    ProdutoController(ProdutoRepository produtoRepository){
        this.repository = produtoRepository;
    }
    
     @GetMapping
    public List findAll() {
        return repository.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Tbproduto> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public void create(@RequestBody Tbproduto produto) {
        repository.save(produto);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Tbproduto produto) {
        return repository.findById(id)
                .map(record -> {
                    record.setNOME(produto.getNOME());
                    record.setPRECO_COMPRA(produto.getPRECO_COMPRA());
                    record.setPRECO_VENDA(produto.getPRECO_VENDA());
                    record.setQTD(produto.getQTD());
                    Tbproduto updated = repository.save(record);
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

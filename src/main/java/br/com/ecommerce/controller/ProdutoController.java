package br.com.ecommerce.controller;

import br.com.ecommerce.dto.ProdutoUpdateDto;
import br.com.ecommerce.model.ProdutoModel;
import br.com.ecommerce.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody ProdutoModel produtoModel){
        produtoService.create(produtoModel);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("")
    public void update(@Valid @RequestBody ProdutoUpdateDto produtoUpdateDto){
        produtoService.update(produtoUpdateDto);
    }

    //localhost:8080/produto/3
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        produtoService.delete(id);
    }

    //localhost:8080/produto/3
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> listById (@PathVariable Long id){
        return produtoService.findById(id);
    }

    @GetMapping("/lista/{nome}")
    public ResponseEntity<List<ProdutoModel>> listByNomeContainingIgnoreCase(@PathVariable("nome") String nome){
        return produtoService.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("")
    public ResponseEntity<List<ProdutoModel>> listAll(){
        return produtoService.findAll();
    }

}

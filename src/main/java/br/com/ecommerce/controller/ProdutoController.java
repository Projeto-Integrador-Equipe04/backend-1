package br.com.ecommerce.controller;

import br.com.ecommerce.dto.ProdutoUpdateDto;
import br.com.ecommerce.model.ProdutoModel;
import br.com.ecommerce.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//127.0.0.1:8080/produto
//localhost:8080/produto
//0.0.0.0:8080/produto
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
    public ResponseEntity<ProdutoModel> update(@Valid @RequestBody ProdutoUpdateDto produtoUpdateDto){
        return produtoService.update(produtoUpdateDto);
    }

}

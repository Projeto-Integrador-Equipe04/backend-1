package br.com.ecommerce.service;

import br.com.ecommerce.dto.ProdutoUpdateDto;
import br.com.ecommerce.model.ProdutoModel;
import br.com.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProdutoModel> create(ProdutoModel produtoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtoModel));
    }

    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProdutoModel> update(ProdutoUpdateDto produtoUpdateDto){
        Optional<ProdutoModel> produtoOpt = produtoRepository.findById(produtoUpdateDto.id());
        if(produtoOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com o id informado: " + produtoUpdateDto.id());
        }else{
            ProdutoModel produtoModel = new ProdutoModel(produtoUpdateDto.id(), produtoUpdateDto.nome(), produtoUpdateDto.descricao(), produtoUpdateDto.preco(), produtoUpdateDto.categoria());
            return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produtoModel));
        }
    }

}

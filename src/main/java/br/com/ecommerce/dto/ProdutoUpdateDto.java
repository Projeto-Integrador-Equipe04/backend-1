package br.com.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProdutoUpdateDto(
        @NotNull(message = "O atributo ID é obrigatório")
        long id,
        @NotNull(message = "Titulo não pode ficar em branco")
        @Size(min = 5, max = 60, message = "Nome deve estar entre 5 a 60 caracteres")
        String nome,

        @NotNull(message = "Descricao não pode ficar em branco")
        @Size(min = 1, max = 255, message = "Descricao deve estar entre 1 a 255 caracteres")
        String descricao,

        @NotNull(message = "Preço não pode ficar em branco")
        Double preco,

        @NotNull(message = "Categoria não pode ficar em branco")
        @Size(min = 1, max = 15, message = "Categoria deve estar entre 1 a 15 caracteres")
        String categoria
){
}

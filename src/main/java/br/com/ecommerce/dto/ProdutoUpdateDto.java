package br.com.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoUpdateDto(
        @NotBlank(message = "O atributo ID é obrigatório")
        long id,
        @NotBlank(message = "O atributo nome é obrigatório")
        String nome,
        @NotBlank(message = "O atributo descricao é obrigatório")
        String descricao,
        @NotNull(message = "O atributo preço é obrigatório")
        double preco,
        @NotBlank(message = "O atributo categoria é obrigatorio")
        String categoria
){
}

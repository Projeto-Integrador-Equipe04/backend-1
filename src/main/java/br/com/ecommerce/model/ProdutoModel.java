package br.com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Titulo não pode ficar em branco")
    @Size(min = 5, max = 60, message = "Nome deve estar entre 5 a 60 caracteres")
    private String nome;

    @NotNull(message = "Descricao não pode ficar em branco")
    @Size(min = 1, max = 255, message = "Descricao deve estar entre 1 a 255 caracteres")
    private String descricao;

    @NotNull(message = "Preço não pode ficar em branco")
    private Double preco;

    @NotNull(message = "Categoria não pode ficar em branco")
    @Size(min = 1, max = 15, message = "Categoria deve estar entre 1 a 15 caracteres")
    private String categoria;

}

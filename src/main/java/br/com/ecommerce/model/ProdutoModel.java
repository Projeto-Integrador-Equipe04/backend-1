package br.com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "tb_produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome não pode ficar em branco")
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

    public ProdutoModel() {}
    public ProdutoModel(Long id, String nome, String descricao, Double preco, String categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

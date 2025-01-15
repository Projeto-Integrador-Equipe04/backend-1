package br.com.ecommerce.repository;

import br.com.ecommerce.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    List<ProdutoModel> findByNomeContainingIgnoreCase(@Param("nome") String nome);
}

package br.com.ellenconceito.persistencia;

import java.util.List;

import br.com.ellenconceito.negocio.produto.Produto;

public interface ProdutoDAO {

	Produto buscarPeloId(Long id);
	
	List<Produto> listaProdutos();
	
	List<Produto> listaProdutosVestidos();
	
	List<Produto> listaProdutosBlusas();
}

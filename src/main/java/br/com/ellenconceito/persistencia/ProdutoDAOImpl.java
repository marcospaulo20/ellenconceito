package br.com.ellenconceito.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ellenconceito.negocio.produto.Categoria;
import br.com.ellenconceito.negocio.produto.Produto;
import br.com.ellenconceito.negocio.produto.Produto.ProdutoBuilder;

public class ProdutoDAOImpl implements ProdutoDAO {

	private static ProdutoDAOImpl instance = new ProdutoDAOImpl();
	private List<Produto> listaProdutos;

	public static ProdutoDAOImpl getInstance() {
		return instance;
	}

	@Override
	public Produto buscarPeloId(Long id) {
		return this.listaProdutos.stream().filter(p -> p.getId().equals(id)).findAny().orElse(new Produto());
	}
	
	public List<Produto> listaProdutosBlusas() {
		return listaProdutos.stream().filter(p->p.getCategoria().equals(Categoria.BLUSA)).collect(Collectors.toList());
	}

	public List<Produto> listaProdutosVestidos() {
		return listaProdutos.stream().filter(p->p.getCategoria().equals(Categoria.VESTIDO)).collect(Collectors.toList());
	}
	
	public List<Produto> listaProdutos() {
		listaProdutos = new ArrayList<Produto>();

		List<String> d1 = new ArrayList<String>();
		d1.add("Blusa feminina");
		d1.add("Manga 3/4");
		d1.add("Gola redonda");
		d1.add("Com aplicação de pedras no decote");
		Produto p1 = new ProdutoBuilder().id(1L).nome("BLUSA COM PEDRARIA").valor(60.0).categoria(Categoria.BLUSA)
				.foto("resources/img/blusa/modelo_blusa_1.jpg").descricao(d1).build();
		Produto p2 = new ProdutoBuilder().id(2L).nome("VESTIDO ESTAPADO").valor(60.0).categoria(Categoria.VESTIDO)
				.foto("resources/img/vestido/modelo_vestido_1.jpg").build();
		Produto p3 = new ProdutoBuilder().id(3L).nome("VESTIDO ESTAPADO").valor(60.0).categoria(Categoria.VESTIDO)
				.foto("resources/img/vestido/modelo_vestido_2.jpg").build();
		Produto p4 = new ProdutoBuilder().id(4L).nome("VESTIDO ESTAPADO").valor(60.0).categoria(Categoria.VESTIDO)
				.foto("resources/img/vestido/modelo_vestido_3.jpg").build();
		Produto p5 = new ProdutoBuilder().id(5L).nome("VESTIDO ESTAPADO").valor(60.0).categoria(Categoria.VESTIDO)
				.foto("resources/img/vestido/modelo_vestido_4.jpg").build();
		Produto p6 = new ProdutoBuilder().id(6L).nome("VESTIDO ESTAPADO").valor(60.0).categoria(Categoria.VESTIDO)
				.foto("resources/img/vestido/modelo_vestido_5.jpg").build();
		Produto p7 = new ProdutoBuilder().id(7L).nome("BLUSA").valor(30.0).categoria(Categoria.BLUSA)
				.foto("resources/img/blusa/modelo_blusa_2.jpg").build();
		Produto p8 = new ProdutoBuilder().id(8L).nome("BLUSA").valor(30.0).categoria(Categoria.BLUSA)
				.foto("resources/img/blusa/modelo_blusa_3.jpg").build();
		Produto p9 = new ProdutoBuilder().id(9L).nome("BLUSA BÁSICA COM PEDRARIA").valor(30.0).categoria(Categoria.BLUSA)
				.foto("resources/img/blusa/modelo_blusa_4.jpg").build();
		Produto p10 = new ProdutoBuilder().id(10L).nome("BLUSA & SAIA").valor(50.0).categoria(Categoria.BLUSA)
				.foto("resources/img/saia_blusa/modelo_saia_blusa_6.jpg").build();
		Produto p11 = new ProdutoBuilder().id(11L).nome("VESTIDO").valor(60.0).categoria(Categoria.VESTIDO)
				.foto("resources/img/vestido/modelo_vestido_6.jpg").build();
		Produto p12 = new ProdutoBuilder().id(12L).nome("VESTIDO").valor(60.0).categoria(Categoria.VESTIDO)
				.foto("resources/img/vestido/modelo_vestido_7.jpg").build();
		
		listaProdutos.add(p1);
		listaProdutos.add(p2);
		listaProdutos.add(p3);
		listaProdutos.add(p4);
		listaProdutos.add(p5);
		listaProdutos.add(p6);
		listaProdutos.add(p7);
		listaProdutos.add(p8);
		listaProdutos.add(p9);
		listaProdutos.add(p10);
		listaProdutos.add(p11);
		listaProdutos.add(p12);

		return listaProdutos;
	}
}

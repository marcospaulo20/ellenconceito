package br.com.ellenconceito.negocio.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.com.ellenconceito.negocio.produto.Produto;
import br.com.ellenconceito.persistencia.ProdutoDAO;
import br.com.ellenconceito.persistencia.ProdutoDAOImpl;

@ViewScoped
@ManagedBean
public class ProdutoBean {
	
	private Produto produto;
	@SuppressWarnings("unused")
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	@SuppressWarnings("unused")
	private List<Produto> listaProdutoBlusas = new ArrayList<Produto>();
	
	@SuppressWarnings("unused")
	private List<Produto> listaProdutoVestidos = new ArrayList<Produto>();
	
	private ProdutoDAO produtoDAO = ProdutoDAOImpl.getInstance();
	
	public Produto getProduto() {
		if (this.produto == null) {
			this.produto = buscarProdutoPorUrl();
			return produto;
		}
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getListaProdutos() {
		return produtoDAO.listaProdutos();
	}
	
	public List<Produto> getListaProdutoBlusas() {
		return produtoDAO.listaProdutosBlusas();
	}
	
	public List<Produto> getListaProdutoVestidos() {
		return produtoDAO.listaProdutosVestidos();
	}

	private Produto buscarProdutoPorUrl() {
		String codigoProduto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		Long id = Long.parseLong(codigoProduto);
		return produtoDAO.buscarPeloId(id);
	}
}	

package br.com.ellenconceito.negocio.produto;

import java.util.List;

public class Produto {

	private Long id;

	private String nome;
	private List<String> descricao;
	private String foto;
	private double valor;
	private String tamanho;
	private String cor;
	private boolean status;
	private int estoqueAtual;
	private Categoria categoria;
	
	public Produto() {	}

	private Produto(ProdutoBuilder builder) {
		this.id = builder.id;
		this.nome = builder.nome;
		this.descricao = builder.descricao;
		this.foto = builder.foto;
		this.valor = builder.valor;
		this.tamanho = builder.tamanho;
		this.cor = builder.cor;
		this.status = builder.status;
		this.estoqueAtual = builder.estoqueAtual;
		this.categoria = builder.categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getDescricao() {
		return descricao;
	}

	public void setDescricao(List<String> descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static class ProdutoBuilder {

		private Long id;
		private String nome;
		private List<String> descricao;
		private String foto;
		private double valor;
		private String tamanho;
		private String cor;
		private boolean status;
		private int estoqueAtual;
		private Categoria categoria;

		public ProdutoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public ProdutoBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public ProdutoBuilder descricao(List<String> descricao) {
			this.descricao = descricao;
			return this;
		}

		public ProdutoBuilder foto(String foto) {
			this.foto = foto;
			return this;
		}

		public ProdutoBuilder valor(double valor) {
			this.valor = valor;
			return this;
		}

		public ProdutoBuilder tamanho(String tamanho) {
			this.tamanho = tamanho;
			return this;
		}

		public ProdutoBuilder cor(String cor) {
			this.cor = cor;
			return this;
		}

		public ProdutoBuilder categoria(Categoria categoria) {
			this.categoria = categoria;
			return this;
		}

		public Produto build() {
			return new Produto(this);
		}
	}
}
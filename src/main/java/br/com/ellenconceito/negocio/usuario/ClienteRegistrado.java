package br.com.ellenconceito.negocio.usuario;

import java.io.Serializable;
import java.util.Date;

public class ClienteRegistrado extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Date dataNascimento;
	private String cpf;
	private Endereco endereco;
	private Genero genero;

	private String telefone;
	private Boolean telefoneEntrega = Boolean.FALSE;

	public ClienteRegistrado() {

	}

	private ClienteRegistrado(ClienteRegistradoBuilder builder) {
		this.nome = builder.nome;
		this.dataNascimento = builder.dataNascimento;
		this.cpf = builder.cpf;
		this.endereco = builder.endereco;
		this.genero = builder.genero;
		this.telefone = builder.telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getTelefoneEntrega() {
		return telefoneEntrega;
	}

	public void setTelefoneEntrega(Boolean telefoneEntrega) {
		this.telefoneEntrega = telefoneEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((super.getId() == null) ? 0 : super.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteRegistrado other = (ClienteRegistrado) obj;
		if (super.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!super.getId().equals(other.getId()))
			return false;
		return true;
	}

	public static class ClienteRegistradoBuilder {
		private String nome;
		private Date dataNascimento;
		private String cpf;
		private Endereco endereco;
		private Genero genero;
		private String telefone;

		public ClienteRegistradoBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public ClienteRegistradoBuilder dataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
			return this;
		}

		public ClienteRegistradoBuilder cpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public ClienteRegistradoBuilder Endereco(Endereco endereco) {
			this.endereco = endereco;
			return this;
		}

		public ClienteRegistradoBuilder Genero(Genero genero) {
			this.genero = genero;
			return this;
		}

		public ClienteRegistradoBuilder telefone(String telefone) {
			this.telefone = telefone;
			return this;
		}

		public ClienteRegistrado build() {
			return new ClienteRegistrado(this);
		}
	}

}
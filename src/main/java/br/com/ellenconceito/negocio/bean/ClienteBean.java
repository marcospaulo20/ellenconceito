package br.com.ellenconceito.negocio.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.ellenconceito.negocio.usuario.ClienteRegistrado;
import br.com.ellenconceito.negocio.usuario.Endereco;
import br.com.ellenconceito.negocio.usuario.Genero;
import br.com.ellenconceito.persistencia.ClienteDAO;
import br.com.ellenconceito.persistencia.ClienteDAOImpl;

@SessionScoped
@ManagedBean
public class ClienteBean {
	
	private ClienteRegistrado cliente;
	private ClienteDAO clienteDAO = ClienteDAOImpl.getInstance();
	
	public ClienteRegistrado getCliente() {
		return cliente;
	}
	
	public void setCliente(ClienteRegistrado cliente) {
		this.cliente = cliente;
	}
	
	public String queroMeCadastrar() {
		this.cliente = new ClienteRegistrado();
		
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String usuario = req.getParameter("usuario");
		String email = req.getParameter("email");
		
		this.cliente.setUsuario(usuario);
		this.cliente.setEmail(email);
		
		if(usuario.length() > 3 && email.length() > 10) {		
			return "cadastro.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String cadastarCliente() {
		if(validarCliente(this.cliente)) {
			clienteDAO.cadastrarCliente(this.cliente);
			return "login-cadastro.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	private boolean validarCliente(ClienteRegistrado cliente) {
		if(montarClienteParaCadastro()) {
			return true;
		}
		return false;
	}
	
	private boolean montarClienteParaCadastro() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.cliente.setCpf(req.getParameter("cpf"));
		this.cliente.setNome(req.getParameter("nome"));
		String genero = req.getParameter("genero");
		
		if(genero.equals("Masculino")) {
			this.cliente.setGenero(Genero.MASCULINO);
		}
		this.cliente.setGenero(Genero.FEMININO);
		
		String dataNascimento = req.getParameter("dataNascimento");
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date dtNascimento = format.parse(dataNascimento);
			this.cliente.setDataNascimento(dtNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		
		Endereco endereco = new Endereco();
		endereco.setUf(req.getParameter("uf"));
		endereco.setCep(req.getParameter("cep"));
		endereco.setNumero(Integer.parseInt(req.getParameter("numero")));
		endereco.setRua(req.getParameter("rua"));
		endereco.setComplemento(req.getParameter("complemento"));
		endereco.setBairro(req.getParameter("bairro"));
		endereco.setCidade(req.getParameter("cidade"));
		
		this.cliente.setEndereco(endereco);
		
		this.cliente.setTelefone(req.getParameter("telefone"));
		this.cliente.setSenha(req.getParameter("senha"));
		return true;
	}
}
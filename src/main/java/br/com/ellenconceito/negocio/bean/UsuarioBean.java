package br.com.ellenconceito.negocio.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.ellenconceito.negocio.usuario.Usuario;
import br.com.ellenconceito.persistencia.UsuarioDAO;
import br.com.ellenconceito.persistencia.UsuarioDAOImpl;

@SessionScoped
@ManagedBean
public class UsuarioBean {

	private Usuario usuarioLogado;
	private UsuarioDAO usuarioDAO = UsuarioDAOImpl.getInstance();

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	@PostConstruct
	public void init() {
		this.usuarioLogado = new Usuario();
	}

	public String entrar() {
		
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		if (autenticarCampos(email, senha)) {
			this.usuarioLogado = usuarioDAO.buscarPeloEmailSenha(email, senha);
			if(this.usuarioLogado.getId() == null) {				
				return "";
			}
			return "index.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public String sair() {
		this.usuarioLogado = new Usuario();
		return "index.xhtml";
	}

	private boolean autenticarCampos(String email, String senha) {
		if (email.length() > 5 && senha.length() == 8) {
			return true;
		}
		return false;
	}	
}
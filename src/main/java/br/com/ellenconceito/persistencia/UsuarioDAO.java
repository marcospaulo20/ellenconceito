package br.com.ellenconceito.persistencia;

import br.com.ellenconceito.negocio.usuario.ClienteRegistrado;
import br.com.ellenconceito.negocio.usuario.Usuario;

public interface UsuarioDAO {

	Usuario buscarPeloEmailSenha(String email, String senha);
	
	void salvar(ClienteRegistrado cliente);
}

package br.com.ellenconceito.persistencia;

import br.com.ellenconceito.negocio.usuario.Usuario;

public interface UsuarioDAO {

	Usuario buscarPeloEmailSenha(String email, String senha);		
}

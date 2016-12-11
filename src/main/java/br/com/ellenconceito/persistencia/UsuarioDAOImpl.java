package br.com.ellenconceito.persistencia;

import java.util.HashMap;
import java.util.Map;

import br.com.ellenconceito.negocio.usuario.ClienteRegistrado;
import br.com.ellenconceito.negocio.usuario.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static UsuarioDAOImpl instance = new UsuarioDAOImpl();
	private static Map<Long, Usuario> usuarios = new HashMap<Long, Usuario>();
	private static Long nextId = 0L;

	public static UsuarioDAOImpl getInstance() {
		return instance;
	}

	public void popularUsuarios() {		
		usuarios.put(1L, new Usuario(nextId++, "marcospaulo21", "marcospaulo@gmail.com", "12345678"));
	}

	@Override
	public Usuario buscarPeloEmailSenha(String email, String senha) {
		popularUsuarios();
		Usuario usuario = usuarios.values().stream()
				.filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha)).findAny().orElse(new Usuario());
		return usuario;
	}

	@Override
	public void salvar(ClienteRegistrado cliente) {
		if(cliente != null) {
			if(cliente.getId() == null) {
				nextId++;
				cliente.setId(nextId);
			}
			usuarios.put(cliente.getId(), cliente);
		}
	}

}

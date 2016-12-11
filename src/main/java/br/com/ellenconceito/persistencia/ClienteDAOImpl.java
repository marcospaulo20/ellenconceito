package br.com.ellenconceito.persistencia;

import br.com.ellenconceito.negocio.usuario.ClienteRegistrado;

public class ClienteDAOImpl implements ClienteDAO {

	private static ClienteDAOImpl instance = new ClienteDAOImpl();

	private UsuarioDAO usuarioDAO = UsuarioDAOImpl.getInstance();
	
	public static ClienteDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void cadastrarCliente(ClienteRegistrado cliente) {
		usuarioDAO.salvar(cliente);
	}

}

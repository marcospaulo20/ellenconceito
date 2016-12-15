package br.com.ellenconceito.persistencia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.ellenconceito.negocio.usuario.ClienteRegistrado;
import br.com.ellenconceito.negocio.usuario.ClienteRegistrado.ClienteRegistradoBuilder;
import br.com.ellenconceito.negocio.usuario.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static UsuarioDAOImpl instance = new UsuarioDAOImpl();
	private static Map<Long, Usuario> usuarios = new HashMap<Long, Usuario>();

	public static UsuarioDAOImpl getInstance() {
		return instance;
	}

	public void popularUsuarios() {
		for(Usuario u : getClienteFile()) {
			usuarios.put(u.getId(), u);
		}
	}

	@Override
	public Usuario buscarPeloEmailSenha(String email, String senha) {
		popularUsuarios();
		Usuario usuario = usuarios.values().stream()
				.filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha)).findAny().orElse(new Usuario());
		return usuario;
	}

	private List<ClienteRegistrado> getClienteFile() {
		List<ClienteRegistrado> listaClienteRegistrados = new ArrayList<ClienteRegistrado>();
		ClienteRegistrado novoCliente;

		File file = new File("C:\\tmp\\clientes.txt");
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] clientesArquivo = line.split(";");
				
				Long id = Long.parseLong(clientesArquivo[0]);
				String email = clientesArquivo[1];
				String usuario = clientesArquivo[2];
				String senha = clientesArquivo[3];
				String nome = clientesArquivo[4];
				
				novoCliente = new ClienteRegistradoBuilder().nome(nome).build();
				novoCliente.setId(id);
				novoCliente.setEmail(email);
				novoCliente.setUsuario(usuario);
				novoCliente.setSenha(senha);

				listaClienteRegistrados.add(novoCliente);
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaClienteRegistrados;
	}
}

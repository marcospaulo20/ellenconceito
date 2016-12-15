package br.com.ellenconceito.persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.ellenconceito.negocio.usuario.ClienteRegistrado;
import br.com.ellenconceito.negocio.usuario.ClienteRegistrado.ClienteRegistradoBuilder;

public class ClienteDAOImpl implements ClienteDAO {

	private static ClienteDAOImpl instance = new ClienteDAOImpl();

	public static ClienteDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void cadastrarCliente(ClienteRegistrado cliente) {
		ClienteRegistrado clienteRegistrado = new ClienteRegistradoBuilder().nome(cliente.getNome())
				.cpf(cliente.getCpf()).dataNascimento(cliente.getDataNascimento()).Genero(cliente.getGenero())
				.Endereco(cliente.getEndereco()).telefone(cliente.getTelefone()).build();
		clienteRegistrado.setUsuario(cliente.getUsuario());
		clienteRegistrado.setEmail(cliente.getEmail());
		clienteRegistrado.setSenha(cliente.getSenha());
		salvar(cliente);
	}

	private void salvar(ClienteRegistrado clienteRegistrado) {
		String COMMA_DELIMITER = ";";

		StringBuilder sb = new StringBuilder();
		try {
			sb.append(String.valueOf(1)).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getEmail())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getUsuario())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getSenha())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getNome())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getDataNascimento())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getCpf())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getEndereco().getRua())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getEndereco().getComplemento())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getEndereco().getUf())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getEndereco().getNumero())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getEndereco().getCep())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getEndereco().getBairro())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getEndereco().getCidade())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getGenero())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getTelefone())).append(COMMA_DELIMITER)
					.append(String.valueOf(clienteRegistrado.getTelefoneEntrega()));

			File file = new File("C:\\tmp\\clientes.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.write(sb.toString());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

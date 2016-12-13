package br.com.ellenconceito.persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ellenconceito.negocio.usuario.ClienteRegistrado;
import br.com.ellenconceito.negocio.usuario.ClienteRegistrado.ClienteRegistradoBuilder;

public class ClienteDAOImpl implements ClienteDAO {

	private static ClienteDAOImpl instance = new ClienteDAOImpl();

	public static ClienteDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void cadastrarCliente(ClienteRegistrado cliente) {
		ClienteRegistrado clienteRegistrado = new ClienteRegistradoBuilder()
				.nome(cliente.getNome()).cpf(cliente.getCpf())
				.dataNascimento(cliente.getDataNascimento()).Genero(cliente.getGenero())
				.Endereco(cliente.getEndereco()).telefone(cliente.getTelefone()).build();
		clienteRegistrado.setId(1L);
		clienteRegistrado.setUsuario(cliente.getUsuario());
		clienteRegistrado.setEmail(cliente.getEmail());
		clienteRegistrado.setSenha(cliente.getSenha());
		escrever(cliente);
	}
	
	public List<ClienteRegistrado> listaClientes() {
		return getFile("file/clientes.txt");
	}

	private List<ClienteRegistrado> getFile(String fileName) {
		List<ClienteRegistrado> listaClienteRegistrados = new ArrayList<ClienteRegistrado>();
		ClienteRegistrado novoCliente;

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

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
	
	private void escrever(ClienteRegistrado clienteRegistrado) {
		String COMMA_DELIMITER = ";";
		String NEW_LINE_SEPARATOR = "\n";
		String FILE_HEADER = "id;email;usuario;senha;nome;dataNascimento;cpf;rua;complemento;uf;numero;cep;bairro;cidade;genero;telefone;telefoneEntrega";
		
		FileWriter fileWriter = null;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			fileWriter = new FileWriter(classLoader.getResource("file/clientes.txt").getFile());
			fileWriter.append(FILE_HEADER.toString());
			
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			fileWriter.append(String.valueOf(clienteRegistrado.getId()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getEmail()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getUsuario()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getSenha()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getNome()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getDataNascimento()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getCpf()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getEndereco().getRua()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getEndereco().getComplemento()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getEndereco().getUf()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getEndereco().getNumero()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getEndereco().getCep()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getEndereco().getBairro()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getEndereco().getCidade()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getGenero()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getTelefone()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(clienteRegistrado.getTelefoneEntrega()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

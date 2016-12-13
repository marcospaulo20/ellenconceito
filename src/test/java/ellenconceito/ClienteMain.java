package ellenconceito;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ellenconceito.negocio.usuario.ClienteRegistrado;
import br.com.ellenconceito.negocio.usuario.ClienteRegistrado.ClienteRegistradoBuilder;

public class ClienteMain {

	public static void main(String[] args) {
		ClienteMain obj = new ClienteMain();
		List<ClienteRegistrado> clienteRegistrados = obj.getFile("file/clientes.txt");
		for (ClienteRegistrado cr : clienteRegistrados) {
			System.out.println(cr.getId());
			System.out.println(cr.getEmail());
			System.out.println(cr.getUsuario());
		}
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
}

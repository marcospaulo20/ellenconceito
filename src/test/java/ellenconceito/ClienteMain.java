package ellenconceito;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.ellenconceito.negocio.usuario.ClienteRegistrado;
import br.com.ellenconceito.negocio.usuario.ClienteRegistrado.ClienteRegistradoBuilder;

public class ClienteMain {

	public static void main(String[] args) throws IOException {
		String content = "This is the content to write into file oioi";
		File file = new File("clientes.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();
		
		
	}

	private List<ClienteRegistrado> getFile(String fileName) {
		ClienteMain obj = new ClienteMain();
		List<ClienteRegistrado> clienteRegistrados = obj.getFile("file/clientes.txt");
		for (ClienteRegistrado cr : clienteRegistrados) {
			System.out.println(cr.getId());
			System.out.println(cr.getEmail());
			System.out.println(cr.getUsuario());
		}
		
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

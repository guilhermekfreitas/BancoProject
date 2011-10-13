package banco.servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class TrataConexao implements Runnable {
	private Socket server;
	private String line;

	TrataConexao(Socket server) {
		this.server=server;
	}

	public void run () {


		try {
			// Get input from the client

			ObjectInputStream entrada = new ObjectInputStream(server.getInputStream());

			System.out.println("Chegou isso:" + entrada.readObject()); 
//			entrada.close();
			
			String resposta = "0 guilherme gui";
			ObjectOutputStream saida = new ObjectOutputStream(server.getOutputStream());
			saida.writeObject(resposta);

//			saida.close();
			server.close();
		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (server != null){
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
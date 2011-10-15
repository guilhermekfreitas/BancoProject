package banco.cliente;

import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JOptionPane;

import banco.cliente.modelo.Servidor;
import banco.cliente.util.SessaoApp;
import banco.cliente.view.LoginView;

public class ClienteMain {
	public static void main(String[] args) {
		ClienteMain main = new ClienteMain();
	}
	
	
	public ClienteMain(){
		
		SessaoApp sessao = SessaoApp.getSessaoApp();
		
		Servidor servidor = new Servidor("Servidor Default", "192.168.1.103", 5000);
		sessao.setServidor(servidor);
		
		DatagramSocket client_socket;
		try {
			client_socket = new DatagramSocket();
			client_socket.setSoTimeout(1000);

			sessao.setSocket(client_socket);
			LoginView loginForm = new LoginView(sessao);
		} catch (SocketException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel contactar o servidor!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
		// testing
	} 
	
}

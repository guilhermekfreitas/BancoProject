package banco.cliente;

import banco.cliente.modelo.Servidor;
import banco.cliente.util.SessaoApp;
import banco.cliente.view.LoginView;

public class ClienteMain {
	public static void main(String[] args) {
		ClienteMain main = new ClienteMain();
	}
	
	
	public ClienteMain(){
		
		SessaoApp sessao = SessaoApp.getSessaoApp();
		
		Servidor servidor = new Servidor("Servidor A", "192.168.1.104", 4446);
		sessao.setServidor(servidor);
		
		LoginView loginForm = new LoginView(sessao);
		// testing
	} 
	
}

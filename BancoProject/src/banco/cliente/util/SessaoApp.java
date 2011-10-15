package banco.cliente.util;

import java.net.DatagramSocket;

import banco.cliente.modelo.Cliente;
import banco.cliente.modelo.Servidor;

public class SessaoApp {
	
	private static SessaoApp sessao;
	
	private Cliente usuarioLogado;
	private Servidor servidor;

	private DatagramSocket socket;


	private SessaoApp(){
	}
	
	public DatagramSocket getSocket() {
		return socket;
	}
	
	public static SessaoApp getSessaoApp(){
		if (sessao == null)
			sessao = new SessaoApp();
		return sessao;
	}
	
	public Cliente getUsuarioLogado() {
		return usuarioLogado;
	}
	public  void setUsuarioLogado(Cliente usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public Servidor getServidor() {
		return servidor;
	}
	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public void setSocket(DatagramSocket client_socket) {
		this.socket = client_socket;
	}
	
	
}

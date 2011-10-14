package banco.cliente.util;

import banco.cliente.modelo.Cliente;
import banco.cliente.modelo.Servidor;

public class SessaoApp {
	
	private static SessaoApp sessao;
	
	private Cliente usuarioLogado;
	private Servidor servidor;

	private SessaoApp(){
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
	
	
}

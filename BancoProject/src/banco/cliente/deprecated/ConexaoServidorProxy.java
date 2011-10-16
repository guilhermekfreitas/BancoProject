package banco.cliente.deprecated;

import banco.cliente.modelo.Servidor;
import banco.cliente.modelo.conexao.ConexaoServidor;

public class ConexaoServidorProxy implements ConexaoServidor {

	@Override
	public String comunicaServidor(String msg, Servidor servidor) {

		System.out.println("Conectando com servidor " + servidor);
		System.out.println("Mensagem: " + msg);
		
		if (msg.contains("1")){
			System.out.println("Quer sacar");
		}
		
		return "0retorno";
	}

}

package banco.cliente;

import banco.cliente.refactoring.Servidor;

public class ConexaoServidorProxy implements ConexaoServidor {

	@Override
	public String comunicaServidor(String msg, Servidor servidor) {

		System.out.println("Conectando com servidor " + servidor);
		System.out.println("Mensagem: " + msg);
		
		if (msg.contains("1")){
			System.out.println("Quer sacar");
		}
		
		return "retorno";
	}

}

package banco.cliente;

public class ConexaoServidorProxy implements ConexaoServidor {

	@Override
	public String ComunicaServidor(String msg, String servidor) {

		System.out.println("Conectando com servidor " + servidor);
		System.out.println("Mensagem: " + msg);
		
		if (msg.contains("1")){
			System.out.println("Quer sacar");
		}
		
		return "retorno";
	}

}

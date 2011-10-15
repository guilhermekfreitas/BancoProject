package banco.cliente.modelo.conexao;

import java.net.SocketException;

public class ServidorIndisponivelException extends RuntimeException {

	public ServidorIndisponivelException(String message, Exception exception) {
		super(message, exception);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2748418389913396139L;

}

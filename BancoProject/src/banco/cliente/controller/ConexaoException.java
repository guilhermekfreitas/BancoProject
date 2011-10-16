package banco.cliente.controller;

public class ConexaoException extends RuntimeException {

	public ConexaoException(){
		
	}
	
	public ConexaoException(String message) {
		super(message);
	}

	public ConexaoException(String mensagem, Exception e) {
		super(mensagem, e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6470329363300760898L;
	/**
	 * 
	 */
	
}

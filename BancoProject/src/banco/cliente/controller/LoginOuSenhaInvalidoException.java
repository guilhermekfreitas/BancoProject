package banco.cliente.controller;

public class LoginOuSenhaInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5134539336980054374L;

	public LoginOuSenhaInvalidoException(String message){
		super(message);
	}
	
}

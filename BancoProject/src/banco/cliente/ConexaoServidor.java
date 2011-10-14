package banco.cliente;

import banco.cliente.refactoring.ConexaoException;
import banco.cliente.refactoring.Servidor;

public interface ConexaoServidor {
	public String comunicaServidor(String msg, Servidor servidor)
		throws ConexaoException;
}

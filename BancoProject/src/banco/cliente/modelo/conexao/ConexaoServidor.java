package banco.cliente.modelo.conexao;

import banco.cliente.modelo.Servidor;
import banco.cliente.refactoring.ConexaoException;

public interface ConexaoServidor {
	public String comunicaServidor(String msg, Servidor servidor)
		throws ConexaoException;
}

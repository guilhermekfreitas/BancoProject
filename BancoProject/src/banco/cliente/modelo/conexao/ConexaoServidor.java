package banco.cliente.modelo.conexao;

import banco.cliente.controller.ConexaoException;
import banco.cliente.modelo.Servidor;

public interface ConexaoServidor {
	public String comunicaServidor(String msg, Servidor servidor)
		throws ConexaoException;
}

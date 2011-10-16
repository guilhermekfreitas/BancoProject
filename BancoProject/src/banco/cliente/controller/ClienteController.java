package banco.cliente.controller;

import banco.cliente.modelo.Cliente;
import banco.cliente.modelo.conexao.ConexaoServidor;
import banco.cliente.modelo.conexao.ConexaoServidorUDP;
import banco.cliente.util.SessaoApp;
import banco.cliente.util.TipoComando;

public class ClienteController {

	public ClienteController() {
	}

	public void cadastraCliente(Cliente cliente)
			throws DadosIncompletosException, ErroCadastroException, ConexaoException {

		validaCliente(cliente);
		enviaCliente(cliente);

	}

	private void enviaCliente(Cliente cliente) 
			throws ErroCadastroException, ConexaoException {

		String mensagem = geraMensagem(cliente);

		
		SessaoApp sessaoApp = SessaoApp.getSessaoApp();
		ConexaoServidor conexaoServidor = new ConexaoServidorUDP(sessaoApp);
		String resposta = conexaoServidor.comunicaServidor(mensagem, null);
		System.out.println("Resposta do servidor:" + resposta);

		if (resposta.equals(TipoComando.ERRO.getComando())){
			throw new ErroCadastroException("Falha ao efetuar cadastro");
		}

	}


	private String geraMensagem(Cliente cliente){

		String msg = TipoComando.CADASTRO.getComando() + " ";
		msg += String.format("insert into clientes values (%s,'%s','%s','%s','%s','%s','%s',0.0)",
				cliente.getNumConta(),
				cliente.getNome(),
				cliente.getCpf(),
				cliente.getRg(),
				cliente.getDataNasc(),
				cliente.getLogin(),
				cliente.getSenha());
		return msg;
	}

	private void validaCliente(Cliente cliente)	
			throws DadosIncompletosException {
		boolean valida = true;

		if (isInvalido(cliente.getNome())){
			valida = false;
		}
		if (isInvalido(cliente.getCpf())){
			valida = false;
		}
		if (isInvalido(cliente.getRg())){
			valida = false;
		}
		if (isInvalido(cliente.getDataNasc())){
			valida = false;
		}
		if (isInvalido(cliente.getNome())){
			valida = false;
		}
		if (isInvalido(cliente.getNumConta())){
			valida = false;
		}
		if (isInvalido(cliente.getLogin())){
			valida = false;
		}
		if (isInvalido(cliente.getSenha())){
			valida = false;
		}

		if (!valida)
			throw new DadosIncompletosException("Campo(s) não foram preenchidos corretamente!");

	}

	private boolean isInvalido(String campo){
		return (campo == null || campo.trim().isEmpty());
	}

}

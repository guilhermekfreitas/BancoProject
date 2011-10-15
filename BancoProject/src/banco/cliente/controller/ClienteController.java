package banco.cliente.controller;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import banco.cliente.deprecated.Login;
import banco.cliente.modelo.Cliente;
import banco.cliente.modelo.Servidor;
import banco.cliente.modelo.conexao.ConexaoServidor;
import banco.cliente.modelo.conexao.ConexaoServidorUDP;
import banco.cliente.util.SessaoApp;
import banco.cliente.util.TipoComando;

public class ClienteController {

	private Servidor servidor;

	public ClienteController(Servidor servidor) {
		this.servidor = servidor;
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




//		Socket socket = null;
//		String resposta = null;
//		try {
//
//
//			socket = new Socket(servidor.getEnderecoIP(), servidor.getPorta());
//
//			// mudar para BUfferedReader
//			ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
//			saida.writeObject(mensagem);
//			saida.flush();
//
//			// mudar tbm
//			ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
//			entrada.read();
//			resposta = entrada.toString();
//
//
//
//		} catch (UnknownHostException e) {
//			throw new ConexaoException("Erro de conex�o", e);
//		} catch (IOException e) {
//			throw new ConexaoException("Erro de conex�o", e);
//		} finally {
//			if(socket!=null)
//				try {
//					socket.close();
//				} catch (IOException e) {
//					throw new ConexaoException("Erro de conex�o", e);
//				}
//		}

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
		//		StringBuffer msg = new StringBuffer("2");
		//		msg.append(addCampo(cliente.getNome()));
		//		msg.append(addCampo(cliente.getCpf()));
		//		msg.append(addCampo(cliente.getRg()));
		//		msg.append(addCampo(cliente.getDataNasc()));
		//		msg.append(addCampo(cliente.getNumConta()));
		//		msg.append(addCampo(cliente.getLogin()));
		//		msg.append(addCampo(cliente.getSenha()));

		return msg;
		//		msg = "2 "+Nome+" "+Cpf+" "+RG+" "+DtNasc+" "+Conta+" "+Login+" "+Senha;
	}

	private String addCampo(String campo) {
		return " " + campo;
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
			throw new DadosIncompletosException("Campo(s) n�o foram preenchidos corretamente!");

	}

	private boolean isInvalido(String campo){
		return (campo == null || campo.trim().isEmpty());
	}

}

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
import banco.cliente.util.TipoComando;

public class ClienteController {

	private Servidor servidor;

	public ClienteController(Servidor servidor) {
		this.servidor = servidor;
	}
	
	public void cadastraCliente(Cliente cliente)
		throws CadastroIncompletoException, ErroCadastroException, ConexaoException {
	
		validaCliente(cliente);
		
		enviaCliente(cliente);
		
	}

	private void enviaCliente(Cliente cliente) 
			throws ErroCadastroException, ConexaoException {
		
		String mensagem = geraMensagem(cliente);
		
		Socket socket = null;
		String resposta = null;
		try {
			socket = new Socket(servidor.getEnderecoIP(), servidor.getPorta());
			
			// mudar para BUfferedReader
			ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
	        saida.writeObject(mensagem);
	        saida.flush();
	        
	        // mudar tbm
	        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
	        entrada.read();
	        resposta = entrada.toString();
		} catch (UnknownHostException e) {
			throw new ConexaoException("Erro de conexão", e);
		} catch (IOException e) {
			throw new ConexaoException("Erro de conexão", e);
		} finally {
			if(socket!=null)
				try {
					socket.close();
				} catch (IOException e) {
					throw new ConexaoException("Erro de conexão", e);
				}
		}
		
        if (resposta.equals(TipoComando.ERRO)){
        	throw new ErroCadastroException("Falha ao efetuar cadastro");
        }
        
	}

	
	private String geraMensagem(Cliente cliente){
		
		StringBuffer msg = new StringBuffer("2");
		msg.append(addCampo(cliente.getNome()));
		msg.append(addCampo(cliente.getCpf()));
		msg.append(addCampo(cliente.getRg()));
		msg.append(addCampo(cliente.getDataNasc()));
		msg.append(addCampo(cliente.getNumConta()));
		msg.append(addCampo(cliente.getLogin()));
		msg.append(addCampo(cliente.getSenha()));
		
		return msg.toString();
//		msg = "2 "+Nome+" "+Cpf+" "+RG+" "+DtNasc+" "+Conta+" "+Login+" "+Senha;
	}

	private String addCampo(String campo) {
		return " " + campo;
	}

	private void validaCliente(Cliente cliente)	
		throws CadastroIncompletoException {
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
	    	throw new CadastroIncompletoException("Campo(s) não foram preenchidos corretamente!");
		
	}
	
	private boolean isInvalido(String campo){
		return (campo == null || campo.trim().isEmpty());
	}

}

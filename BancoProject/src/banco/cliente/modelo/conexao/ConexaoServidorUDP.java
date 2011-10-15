package banco.cliente.modelo.conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import banco.cliente.controller.ConexaoException;
import banco.cliente.controller.LoginOuSenhaInvalidoException;
import banco.cliente.modelo.Servidor;
import banco.cliente.util.SessaoApp;
import banco.cliente.util.TipoComando;

public class ConexaoServidorUDP implements ConexaoServidor {

	private DatagramSocket client_socket;
	private Servidor servidor;

	public ConexaoServidorUDP(DatagramSocket socket, Servidor servidor) {

		this.client_socket = socket;
		this.servidor = servidor;
		//		
		//		try {
		//			client_socket = new DatagramSocket();
		//			client_socket.setSoTimeout(500);
		//		} catch (SocketException e) {
		//			throw new ConexaoException("Não foi possível conectar-se com: " + servidor, e);
		//		}
	}

	public ConexaoServidorUDP(SessaoApp sessaoApp) {
		this.client_socket = sessaoApp.getSocket();
		this.servidor = sessaoApp.getServidor();
	}

	@Override
	public String comunicaServidor(String msg, Servidor servidor2)
			throws ConexaoException {

		// lançar excecao se retornasse [0]

		System.out.println("MSG ===> " + msg + " para servidor: " + servidor);

		byte[] send_data = new byte[1024];

		try {
			
			InetAddress IPAddress =  InetAddress.getByName(servidor.getEnderecoIP());

			send_data = msg.getBytes();

			DatagramPacket send_packet = new DatagramPacket(send_data,
					send_data.length, 
					IPAddress, servidor.getPorta());

			client_socket.send(send_packet);

			byte[] dadosRecebidos = new byte[1000];
			DatagramPacket recebido = new DatagramPacket(dadosRecebidos,dadosRecebidos.length);
			client_socket.receive(recebido);
			System.out.println(new String(dadosRecebidos));

			String resposta = new String(dadosRecebidos).trim();
			
			if (resposta.equals(TipoComando.ERRO.getComando())){
				throw new LoginOuSenhaInvalidoException("Login e/ou Senha inválidos!");
			}
			// casos com mais de um retorno
			try{
				while (recebido != null){
					client_socket.receive(recebido);
					System.out.println(new String(dadosRecebidos));
					resposta += new String(dadosRecebidos);
				}
			} catch (SocketTimeoutException exc){
			}

			return resposta.trim();
		} catch (SocketException e) {
			throw new ServidorIndisponivelException("Erro de conexão com o servidor: " + servidor,e);
		} catch (UnknownHostException e) {
			throw new ServidorIndisponivelException("Servidor " + servidor + "indisponível!",e);
		} catch (IOException e) {
			throw new ServidorIndisponivelException("Erro de I/O no Servidor: " + servidor,e);
		}
	}



}

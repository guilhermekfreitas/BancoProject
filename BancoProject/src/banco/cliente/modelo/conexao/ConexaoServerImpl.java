package banco.cliente.modelo.conexao;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import banco.cliente.controller.ConexaoException;
import banco.cliente.modelo.Servidor;
import banco.cliente.util.SessaoApp;

public class ConexaoServerImpl implements ConexaoServidor {

	private Socket socket;
	
	public ConexaoServerImpl(Socket socket)  {
		this.socket = socket;
		
		Servidor servidor = SessaoApp.getSessaoApp().getServidor();
		
		try {
			this.socket = new Socket(servidor.getEnderecoIP(), servidor.getPorta());
		} catch (UnknownHostException e) {
			throw new ConexaoException("Não foi possível conectar-se com: " + servidor, e);
		} catch (IOException e) {
			throw new ConexaoException("Não foi possível conectar-se com: " + servidor, e);
		}
	}
	
	@Override
	public String comunicaServidor(String msg, Servidor servidor)
		throws ConexaoException {
        
        System.out.println("[ACESSANDO SERVIDOR]: " + servidor);
        //Abrindo conexÃ£o
        StringBuffer resposta = new StringBuffer("0");
        try {
            PrintWriter saida = new PrintWriter(socket.getOutputStream(),true);
            saida.println(msg);
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            
            resposta = new StringBuffer();            
            String buffer;
            while ((buffer = entrada.readLine()) != null){
            	resposta.append(buffer);
            }
        }catch (UnknownHostException e){
        	throw new ConexaoException("Não foi possível conectar-se com: " + servidor, e);
        }catch (EOFException e){
        	throw new ConexaoException("Não foi possível conectar-se com: " + servidor, e);
        }catch (ConnectException exc ){
        	throw new ConexaoException("Não foi possível conectar-se com: " + servidor, exc);
        }
        catch (IOException e){
        	throw new ConexaoException("Erro de conexão com servidor : " + servidor, e);
		} finally {
        }
    return resposta.toString();
	}


}

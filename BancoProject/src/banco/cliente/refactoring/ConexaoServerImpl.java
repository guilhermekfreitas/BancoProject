package banco.cliente.refactoring;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import banco.cliente.ConexaoServidor;

public class ConexaoServerImpl implements ConexaoServidor {

	@Override
	public String comunicaServidor(String msg, Servidor servidor) {
		Socket socket = null;
        String resposta = "0";
        
        System.out.println("[ACESSANDO SERVIDOR]: " + servidor);
        //Abrindo conexão
        int serverPort = servidor.getPorta();
        try {
            socket = new Socket(servidor.getEnderecoIP(), serverPort);
            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            saida.writeObject(msg);
            saida.flush();
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            entrada.read();
            resposta = entrada.toString();
        }catch (UnknownHostException e){
        	e.printStackTrace();
        }catch (EOFException e){
        	e.printStackTrace();
        }catch (IOException e){
        	e.printStackTrace();
        } finally {
            if(socket!=null)
                try {
                    socket.close();
                }
                catch (IOException e){
                	e.printStackTrace();
                }
       }
    return resposta;
	}


}

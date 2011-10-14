package banco.cliente.refactoring;

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

import banco.cliente.ConexaoServidor;

public class ConexaoServerImpl implements ConexaoServidor {

	@Override
	public String comunicaServidor(String msg, Servidor servidor)
		throws ConexaoException {
		Socket socket = null;
        
        System.out.println("[ACESSANDO SERVIDOR]: " + servidor);
        //Abrindo conexÃ£o
        StringBuffer resposta = new StringBuffer("0");
        try {
            socket = new Socket(servidor.getEnderecoIP(), servidor.getPorta());
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
        	e.printStackTrace();
        }catch (EOFException e){
        	e.printStackTrace();
        }catch (ConnectException exc ){
        	throw new ConexaoException("Não foi possível conectar-se com: " + servidor);
        }
        catch (IOException e){
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
    return resposta.toString();
	}


}

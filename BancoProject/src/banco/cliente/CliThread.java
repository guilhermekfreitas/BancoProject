/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco.cliente;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuariio
 */
public class CliThread extends Thread implements ConexaoServidor {

    public String ComunicaServidor(String msg, String servidor){
        Socket socket = null;
        String resposta = "";
        //Abrindo conexão
        int serverPort = 1001;
        try {
            socket = new Socket(servidor, serverPort);
            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            saida.writeObject(msg);
            saida.flush();
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            entrada.read();
            resposta = entrada.toString();
        }catch (UnknownHostException e){
            JOptionPane.showMessageDialog(null, "Sock:"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            //System.out.println("Sock:"+e.getMessage());
            resposta = "0";
        }catch (EOFException e){
            JOptionPane.showMessageDialog(null, "EOF:"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("EOF:"+e.getMessage());
            resposta = "0";
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "IO:"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            //System.out.println("IO:"+e.getMessage());
            resposta = "0";
        } finally {
            if(socket!=null)
                try {
                    socket.close();
                }
                catch (IOException e){
                    JOptionPane.showMessageDialog(null, "Close:"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                    //System.out.println("close:"+e.getMessage());
                    resposta = "0";
                }
       }// try
    return resposta;
    }

}

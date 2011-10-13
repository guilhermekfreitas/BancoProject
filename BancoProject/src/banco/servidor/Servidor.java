package banco.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

  private static int port=4446, maxConnections=10;
  // Listen for incoming connections and handle them
  public static void main(String[] args) {
    int i=0;

    System.out.printf("Ouvindo porta [%d]\n", port);
    
    ServerSocket listener = null;
    try{
      listener = new ServerSocket(port);
      Socket server;

      while(true){

        System.out.println("Aguardando conexao..");
        server = listener.accept();
        
        System.out.println("Chegou alguem..");
        
        TrataConexao trataConexao= new TrataConexao(server);
        Thread t = new Thread(trataConexao);
        t.start();
      }
    } catch (IOException ioe) {
      System.out.println("IOException on socket listen: " + ioe);
      ioe.printStackTrace();
    } finally {
    	try {
    		if (listener != null){
    			listener.close();
    		}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
  }

}
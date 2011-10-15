//UDPClient.java
package banco.servidor;

import java.net.*;
import java.io.*;

class UDPClient 
{
   public static void main(String args[]) throws Exception
   {
   	  
   	  byte[] send_data = new byte[1024];
   	  
      BufferedReader infromuser = 
                        new BufferedReader(new InputStreamReader(System.in));
                        
      DatagramSocket client_socket = new DatagramSocket();
      client_socket.setSoTimeout(2000);
      
      InetAddress IPAddress =  InetAddress.getByName("192.168.1.103");
      
      while (true)
      {
      	
      	System.out.println("Type Something (q or Q to quit): ");
      	
      	String data = infromuser.readLine();
      	
      	if (data.equals("q") || data.equals("Q"))
      	break;
      	
      	else
      	
      	{
      		
      	send_data = data.getBytes();
      
        DatagramPacket send_packet = new DatagramPacket(send_data,
                                                        send_data.length, 
                                                        IPAddress, 5000);
                                                      
        client_socket.send(send_packet);
        
        }
      	
      	byte[] dadosRecebidos = new byte[1000];
		DatagramPacket recebido = new DatagramPacket(dadosRecebidos,dadosRecebidos.length);
		client_socket.receive(recebido);
		System.out.println(new String(dadosRecebidos));
		
		// casos com mais de um retorno
		try{
		while (true){
			client_socket.receive(recebido);
			System.out.println(new String(dadosRecebidos));
		}
		} catch (SocketTimeoutException exc){
		}
		
      }       
       
      client_socket.close();
   }
}

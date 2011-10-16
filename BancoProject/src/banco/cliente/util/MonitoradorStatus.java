package banco.cliente.util;

import java.net.DatagramSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class MonitoradorStatus implements Runnable {

	private DatagramSocket socket;
	private StatusBar statusBar;

	public MonitoradorStatus(StatusBar statusBar){
		this.statusBar = statusBar;
		this.socket = SessaoApp.getSessaoApp().getSocket();
	}

	@Override
	public void run() {

		try {
			// verifica status do socket
			while(true){
				
				System.out.println("Status do Servidor:" 
				+ (estaConectado() ? "CONECTADO" : "DESCONECTADO") );
				Thread.sleep(5000);

				if (!estaConectado()){
					exibirMensagem();
					statusBar.desconectou();
					//System.exit(1);
				}
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	
	private boolean estaConectado(){
		System.out.println(socket.getInetAddress() + " " + socket.getRemoteSocketAddress());
		return !SessaoApp.getSessaoApp().getSocket().isClosed();
	}

	private void exibirMensagem() {
		JOptionPane.showMessageDialog(null, "Conexão com o servidor foi perdida! Tente novamente mais tarde!", "Erro!", JOptionPane.OK_OPTION);
	}

}

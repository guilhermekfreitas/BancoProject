package banco.cliente.util;

import java.net.Socket;
import javax.swing.JOptionPane;

public class MonitoradorStatus implements Runnable {

	private Socket socket;

	public MonitoradorStatus(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			// verifica status do socket
			while(true){
				
				Thread.sleep(5000);

				if (!socket.isConnected()){
					exibirMensagem();
					System.exit(1);
				}
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	private void exibirMensagem() {
		JOptionPane.showMessageDialog(null, "Conexão com o servidor foi perdida! Tente novamente mais tarde!", "Erro!", JOptionPane.OK_OPTION);
	}

}

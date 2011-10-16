package banco.cliente.util;

import java.awt.Dimension;

import javax.swing.JLabel;

public class StatusBar extends JLabel {
	
	private static final String DESCONECTADO = "Status do Servidor: DESCONECTADO";
	private static final String CONECTADO = "Status do Servidor: CONECTADO";
	
	public StatusBar(String mensagem) {
		super();
		super.setPreferredSize(new Dimension(100,16));
		setMessage(CONECTADO);
	}

	private void setMessage(String mensagem) {
		setText(" " + mensagem);
	}

	public void desconectou() {
		setMessage(DESCONECTADO);
	}
}

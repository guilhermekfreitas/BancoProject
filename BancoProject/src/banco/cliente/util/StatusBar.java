package banco.cliente.util;

import java.awt.Dimension;

import javax.swing.JLabel;

public class StatusBar extends JLabel {
	public StatusBar() {
		super();
		super.setPreferredSize(new Dimension(100,16));
		setMessage("Conectado com servidor!");
	}

	private void setMessage(String mensagem) {
		setText(" " + mensagem);
	}
}

package banco.cliente.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import banco.cliente.controller.DadosIncompletosException;
import banco.cliente.util.SessaoApp;
import banco.cliente.modelo.Servidor;

public class ConfiguracaoServidorView {
	private JFrame frame;
	private JTextField tfEnderecoIP;
	private JTextField tfPorta;
	private JLabel lbEnderecoIP;
	private JLabel lbPorta;
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	private SessaoApp sessao;
	
	public ConfiguracaoServidorView() {

		sessao = SessaoApp.getSessaoApp();
		
		frame = new JFrame("Configurações de Servidor");
		
		frame.setResizable(false);
		frame.setLayout(new GridLayout(3, 2));
		
		lbEnderecoIP = new JLabel("Endereço IP:");
		lbPorta = new JLabel("Porta:");
		
		tfEnderecoIP = new JTextField();
		tfEnderecoIP.setMaximumSize(new Dimension(6, 6));
		tfEnderecoIP.setMinimumSize(new Dimension(6, 6));
		tfEnderecoIP.setText(sessao.getServidor().getEnderecoIP());
		
		tfPorta = new JTextField();
		tfPorta.setMaximumSize(new Dimension(6, 6));
		tfPorta.setMinimumSize(new Dimension(6, 6));		
		tfPorta.setText(Integer.toString(sessao.getServidor().getPorta()));
	
		botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(new SalvarActionListener());
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.addActionListener(new CancelarActionListener());
		
		frame.add(lbEnderecoIP);
		frame.add(tfEnderecoIP);
		frame.add(lbPorta);
		frame.add(tfPorta);
		frame.add(botaoCancelar);
		frame.add(botaoSalvar);
		
		frame.setSize(240,90);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}
	
	private void validaDados(String enderecoIP, String porta) {
		if (enderecoIP.isEmpty() || porta.isEmpty())
			throw new DadosIncompletosException("Endereco de IP e/ou Porta vazio(s)");
	}
	
	
	private final class SalvarActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				String enderecoIP = tfEnderecoIP.getText().trim();
				String porta = tfPorta.getText().trim();
				
				validaDados(enderecoIP, porta);
				
				Servidor servidor = new Servidor("Servidor",enderecoIP,Integer.parseInt(porta));
				
				sessao.setServidor(servidor);
				
				JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!" , "", JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
			} catch (DadosIncompletosException exc){
				JOptionPane.showMessageDialog(null, exc.getMessage() , "Erro!", JOptionPane.OK_OPTION);
			}
		}

		
	}
	
	private final class CancelarActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
		}
		
	}
	
}

package banco.cliente.view;

import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import javax.swing.*;

import banco.cliente.controller.ConexaoException;
import banco.cliente.controller.LoginOuSenhaInvalidoException;
import banco.cliente.modelo.Administrador;
import banco.cliente.modelo.Cliente;
import banco.cliente.modelo.conexao.ConexaoServidor;
import banco.cliente.modelo.conexao.ConexaoServidorUDP;
import banco.cliente.modelo.conexao.ServidorIndisponivelException;
import banco.cliente.util.SessaoApp;
import banco.cliente.util.TipoComando;

public class LoginView {

	public Cliente cliente;
	private JLabel lbLogin;
	private JLabel lbSenha;
	private JTextField tfLogin;
	private JLabel lbcadastro;
	private JLabel lbCliqueAqui;
	private JButton botaoOk;
	private JButton botaoCancelar;
	private JPasswordField tfSenha;
	private JFrame frame;

	public LoginView(){
		cliente = new Cliente();
		iniciaComponentes();
		start();
	}


	private void iniciaComponentes() {
		// TODO Auto-generated method stub

		frame = new JFrame("Interface do Cliente - Login");

		lbLogin = new JLabel();
		lbSenha = new JLabel();
		tfLogin = new JTextField();
		lbcadastro = new JLabel();
		lbCliqueAqui = new JLabel();
		botaoOk = new JButton();
		botaoCancelar = new JButton();
		tfSenha = new JPasswordField();


		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Login");

		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("Arquivo");
		JMenuItem menuItem = new JMenuItem("Configurações de Servidor");
		menuItem.addActionListener(new ConfiguracoesServidorActionListener());

		menu.add(menuItem);

		menuBar.add(menu);

		frame.setJMenuBar(menuBar);

		lbLogin.setText("Login: ");
		lbSenha.setText("Senha: ");
		lbcadastro.setText("Se não possui um cadastro ");


		tfLogin.setMaximumSize(new Dimension(6, 6));
		tfLogin.setMinimumSize(new Dimension(6, 6));

		lbCliqueAqui.setForeground(new Color(0, 51, 255));
		lbCliqueAqui.setText("Clique aqui!");
		lbCliqueAqui.addMouseListener(new CadastroActionListener());

		botaoOk.setText("OK");
		botaoOk.addActionListener(new LogarActionListener());

		botaoCancelar.setText("Cancelar");
		botaoCancelar.addActionListener(new FecharActionListener());

		tfSenha.setMaximumSize(new Dimension(6, 6));
		tfSenha.setMinimumSize(new Dimension(6, 6));

		configuraLayout();
		frame.pack();

	}

	private void configuraLayout() {
		GroupLayout layout = new GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbLogin)
								.addComponent(lbSenha))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(lbcadastro)
												.addGap(6, 6, 6)
												.addComponent(lbCliqueAqui))
												.addGroup(layout.createSequentialGroup()
														.addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
																.addComponent(tfSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(tfLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
																.addGap(24, 24, 24))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(61, 61, 61)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbSenha)
								.addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lbcadastro)
										.addComponent(lbCliqueAqui))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(botaoOk)
												.addComponent(botaoCancelar))
												.addContainerGap(40, Short.MAX_VALUE))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
														.addContainerGap(32, Short.MAX_VALUE)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(lbLogin)
																.addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(118, 118, 118))

				);
	}

	private void start(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
	}

	private final class CadastroActionListener extends MouseAdapter {
		public void mouseClicked(MouseEvent evt) {
			abreTelaCadastro();
		}

		private void abreTelaCadastro() {
			frame.dispose();
			CadClienteView cad = new CadClienteView(); // inicia cadastro de cliente
			cad.setLocationRelativeTo(null);
			cad.setVisible(true);
		}
	}


	private final class LogarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			btnOkActionPerformed(evt);
		}

		private void btnOkActionPerformed(ActionEvent evt) {
			String login = tfLogin.getText();
			String senha = new String(tfSenha.getPassword()); 
			String msgEnvio = gerarMsgEnvio(login, senha);

			try {

				validaCampos(login, senha);

				if (isAdmin(login, senha)){
					cliente = new Administrador();
				}else{
					String respostaA = null;
					try
					{
						SessaoApp sessaoApp = SessaoApp.getSessaoApp();
						ConexaoServidor conexaoServidor = new ConexaoServidorUDP(sessaoApp);
						respostaA = conexaoServidor.comunicaServidor(msgEnvio, null);

					} catch (LoginOuSenhaInvalidoException exc){
						JOptionPane.showMessageDialog(null, exc.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
						return;
					} catch (ConexaoException exc){
						JOptionPane.showMessageDialog(null, exc.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
						return;
					} catch (ServidorIndisponivelException exc){
						JOptionPane.showMessageDialog(null, exc.getMessage() + "Verifique se os dados do servidor estão corretos!", "Erro!", JOptionPane.ERROR_MESSAGE);
						return;
					}

					if (respostaA.trim().equals(TipoComando.ERRO.getComando())){
						JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
						return;
					}

					cliente.setCliServidor(SessaoApp.getSessaoApp().getServidor().getEnderecoIP());
					preencheCliente(respostaA);
				}
				frame.dispose();
				SessaoApp.getSessaoApp().setUsuarioLogado(cliente);

				PrincipalView programa = new PrincipalView();
				programa.setLocationRelativeTo(null);
				programa.setVisible(true);

			} catch (LoginOuSenhaInvalidoException exception ){
				JOptionPane.showMessageDialog(null, exception.getMessage() , "Erro!", JOptionPane.OK_OPTION);
			}



		}

		private boolean isAdmin(String login, String senha) {
			return (login.equals("admin"))&&(senha.equals("admin"));
		}

		private void validaCampos(String login, String senha) 
				throws LoginOuSenhaInvalidoException {
			if (login.trim().isEmpty() || senha.trim().isEmpty()){
				throw new LoginOuSenhaInvalidoException("Campo Login e/ou Senha está em branco.");
			}
		}

		private String gerarMsgEnvio(String login, String senha) {
			String msg = TipoComando.LOGIN + " ";
			msg += String.format("select * from clientes where login='%s' and senha='%s'", login,senha);
			return msg;
		}


		private void preencheCliente(String respostaServidor) {

			StringTokenizer tokenizer = new StringTokenizer(respostaServidor);

			cliente.setNumConta(tokenizer.nextToken());
			cliente.setNome(tokenizer.nextToken());
			tokenizer.nextToken(); // cpf
			tokenizer.nextToken(); // rg
			tokenizer.nextToken(); // data
			tokenizer.nextToken(); // login
			tokenizer.nextToken(); // senha
			cliente.setSaldo(tokenizer.nextToken());
		}
	}


	private final class FecharActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			fechaAplicativo();
		}

		private void fechaAplicativo() {
			System.exit(0);
		}
	} 

	private final class ConfiguracoesServidorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			ConfiguracaoServidorView configuracaoServidorView = new ConfiguracaoServidorView();
		}
	} 



}




package banco.cliente.view;

import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import javax.swing.*;

import banco.cliente.controller.ConexaoException;
import banco.cliente.controller.LoginOuSenhaInvalidoException;
import banco.cliente.deprecated.Login;
import banco.cliente.modelo.Administrador;
import banco.cliente.modelo.Cliente;
import banco.cliente.modelo.Servidor;
import banco.cliente.modelo.conexao.ConexaoServerImpl;
import banco.cliente.modelo.conexao.ConexaoServidor;
import banco.cliente.modelo.conexao.ConexaoServidorProxy;
import banco.cliente.modelo.conexao.ConexaoServidorUDP;
import banco.cliente.util.CliThread;
import banco.cliente.util.SessaoApp;
import banco.cliente.util.TipoComando;

public class LoginView {

	public static Servidor servidorA = new Servidor("Servidor A", "192.168.1.104", 4446);
//	public static Servidor servidorB = new Servidor("Servidor B", "127.0.0.1", 4446);
//	public static Servidor servidorC = new Servidor("Servidor C", "127.0.0.1", 4446);
	
	public static Cliente cliente = new Cliente();

	private JLabel lbLogin;
	private JLabel lbSenha;
	private JTextField tfLogin;
	private JLabel lbcadastro;
	private JLabel lbCliqueAqui;
	private JButton botaoOk;
	private JButton botaoCancelar;
	private JPasswordField tfSenha;
	private JFrame frame;

	private Servidor servidor;
	
	public LoginView(SessaoApp sessao){
		iniciaComponentes();
		this.servidor = sessao.getServidor();
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
				//				new Login().setVisible(true);]
				frame.setVisible(true);
			}
		});
	}

	private final class CadastroActionListener extends MouseAdapter {
		public void mouseClicked(MouseEvent evt) {
			abreTelaCadastro();
		}

		private void abreTelaCadastro() {
			// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
			String login = tfLogin.getText();
			String senha = new String(tfSenha.getPassword()); //getText();
			String msgEnvio = gerarMsgEnvio(login, senha);

			try {

				validaCampos(login, senha);

				if (isAdmin(login, senha)){
					cliente = new Administrador();
					frame.dispose();
					PrincipalView programa = new PrincipalView();
					programa.setLocationRelativeTo(null);
					programa.setVisible(true);
				}else{
					//		            ConexaoServidor A = new CliThread();
					String respostaA = null;
					try
					{
						// deve passar um socket aqui
//						ConexaoServidor conexaoServidor = new ConexaoServerImpl(null);
						SessaoApp sessaoApp = SessaoApp.getSessaoApp();
						ConexaoServidor conexaoServidor = new ConexaoServidorUDP(sessaoApp);
						respostaA = conexaoServidor.comunicaServidor(msgEnvio, null);
						System.out.println("Resposta do servidor:" + respostaA);

					} catch (ConexaoException exc){
						JOptionPane.showMessageDialog(null, exc.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
						return;
					}

					if (respostaA.trim().equals(TipoComando.ERRO.getComando())){
						JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
//					if (!respostaA.equals("0")){
						cliente.setCliServidor(servidorA.getEnderecoIP());
						//					cliServidor = servidorA.toString();
						System.out.println("passa por aqui");
						preencheCliente(respostaA);
						frame.dispose();
						
						SessaoApp.getSessaoApp().setUsuarioLogado(cliente);
						
						PrincipalView programa = new PrincipalView();
						programa.setLocationRelativeTo(null);
						programa.setVisible(true);
//					}
//					else{
//						JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
//					}
				}

			} catch (LoginOuSenhaInvalidoException exception ){
				JOptionPane.showMessageDialog(null, exception.getMessage() , "Erro!", JOptionPane.OK_OPTION);
			}



		}

		private boolean isAdmin(String login, String senha) {
			System.out.println(login + " " + senha);
			return (login.equals("admin"))&&(senha.equals("admin"));
		}

		private void validaCampos(String login, String senha) 
				throws LoginOuSenhaInvalidoException {

			System.out.println("Login:<"+login.trim()+">");
			if (login.trim().isEmpty() || senha.trim().isEmpty()){
				throw new LoginOuSenhaInvalidoException("Campo Login e/ou Senha está em branco.");
				//JOptionPane.showMessageDialog(null, , "Erro!", JOptionPane.OK_OPTION);
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
			cliente.setSaldo(tokenizer.nextToken()); // saldo
					
			int tam = respostaServidor.length();
			char palavra[]=respostaServidor.toCharArray();
			int cont = 2;
			int inicio = 0;
			for (int i = 1; i<=3 ;i++){
				inicio = cont;
				while (palavra[cont]!= ' '){
					cont++;
					if (cont == tam){
						break;
					}
				}
				switch(i){
				case 1:
					String numConta = respostaServidor.substring(inicio, cont-1);
					//cliente.setNumConta(numConta);
					cont++;
					break;
				case 2:
					String cliNome = respostaServidor.substring(inicio, cont-1);
					//cliente.setNome(cliNome);
					cont++;
					break;
				case 3:
					String cliSaldo = respostaServidor.substring(inicio);
					cliente.setSaldo(cliSaldo);
					cont++;
					break;
				}
			}
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

}




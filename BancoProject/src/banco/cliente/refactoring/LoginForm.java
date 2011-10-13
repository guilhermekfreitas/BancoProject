package banco.cliente.refactoring;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import banco.cliente.CadCliente;
import banco.cliente.CliThread;
import banco.cliente.ConexaoServidor;
import banco.cliente.ConexaoServidorProxy;
import banco.cliente.Login;
import banco.cliente.Principal;

public class LoginForm {



	//Configurar o IP Conforme os servidores
	public static String servidorA = "127.0.0.1";
	public static String servidorB = "127.0.0.1";
	public static String servidorC = "127.0.0.1";

	public static String cliConta = "";
	public static String cliNome = "";
	public static String cliSaldo = "";
	public static String cliServidor = "";

	private JLabel lbLogin;
	private JLabel lbSenha;
	private JTextField tfLogin;
	private JLabel lbcadastro;
	private JLabel lbCliqueAqui;
	private JButton botaoOk;
	private JButton botaoCancelar;
	private JPasswordField tfSenha;
	private JFrame frame;

	public LoginForm(){
		iniciaComponentes();
		start();
	}


	private void iniciaComponentes() {
		// TODO Auto-generated method stub

		frame = new JFrame();

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
				new Login().setVisible(true);
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
			CadCliente cad = new CadCliente(); // inicia cadastro de cliente
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
			String senha = tfSenha.getSelectedText(); //getText();
			String msgEnvio = "1 "+login+" "+senha;

			if (login.equals("")|| login.equals(" ")){
				JOptionPane.showMessageDialog(null, "Campo Login em branco.", "Erro!", JOptionPane.OK_OPTION);
			}
			if (senha.equals("")||senha.equals(" ")){
				JOptionPane.showMessageDialog(null, "Campo Senha em branco.", "Erro!", JOptionPane.OK_OPTION);
			}

			if ((login.equals("admin"))&&(senha.equals("admin"))){
				cliServidor = "Administrador";
				cliConta = "---";
				cliNome = "Administrador";
				cliSaldo = "R$ 0,00";
				frame.dispose();
				Principal programa = new Principal();
				programa.setLocationRelativeTo(null);
				programa.setVisible(true);
			}else{
				String respostaA = "";
				String respostaB = "";
				String respostaC = "";
				//		            ConexaoServidor A = new CliThread();
				ConexaoServidor A = new ConexaoServidorProxy();
				respostaA = A.ComunicaServidor(msgEnvio, servidorA);

				ConexaoServidor B = new CliThread();
				respostaB = B.ComunicaServidor(msgEnvio, servidorB);

				ConexaoServidor C = new CliThread();
				respostaC = C.ComunicaServidor(msgEnvio, servidorC);

				if (!respostaA.equals("0")){
					cliServidor = servidorA.toString();
					int tam = respostaA.length();
					char palavra[]=respostaA.toCharArray();
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
						case 1:{cliConta = respostaA.substring(inicio, cont-1);
						cont++;
						}
						case 2:{cliNome = respostaA.substring(inicio, cont-1);
						cont++;
						}
						case 3:{cliSaldo = respostaA.substring(inicio);
						cont++;
						}
						}
					}
					frame.dispose();
					Principal programa = new Principal();
					programa.setLocationRelativeTo(null);
					programa.setVisible(true);
				}else if (!respostaB.equals("0")){
					cliServidor = servidorB.toString();
					int tam = respostaB.length();
					char palavra[]=respostaB.toCharArray();
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
						case 1:{cliConta = respostaB.substring(inicio, cont-1);
						cont++;
						}
						case 2:{cliNome = respostaB.substring(inicio, cont-1);
						cont++;
						}
						case 3:{cliSaldo = respostaB.substring(inicio);
						cont++;
						}
						}
					}
					frame.dispose();
					Principal programa = new Principal();
					programa.setLocationRelativeTo(null);
					programa.setVisible(true);
				}else if (!respostaC.equals("0")){
					cliServidor = servidorC.toString();
					int tam = respostaC.length();
					char palavra[]=respostaC.toCharArray();
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
						case 1:{cliConta = respostaC.substring(inicio, cont-1);
						cont++;
						}
						case 2:{cliNome = respostaC.substring(inicio, cont-1);
						cont++;
						}
						case 3:{cliSaldo = respostaC.substring(inicio);
						cont++;
						}
						}
					}
					frame.dispose();
					Principal programa = new Principal();
					programa.setLocationRelativeTo(null);
					programa.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
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




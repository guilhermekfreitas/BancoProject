/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Saldo.java
 *
 * Created on 07/09/2010, 15:01:09
 */

package banco.servidor;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

import banco.cliente.controller.ConexaoException;
import banco.cliente.modelo.Cliente;
import banco.cliente.modelo.conexao.ConexaoServidor;
import banco.cliente.modelo.conexao.ConexaoServidorUDP;
import banco.cliente.util.CliThread;
import banco.cliente.util.SessaoApp;
import banco.cliente.util.TipoComando;

public class SaldoView extends JFrame {

    private JButton btnOk;
    private JLabel lbConta;
    private JLabel lbConta2;
    private JLabel lbData;
    private JLabel lbData2;
    private JLabel lbNome;
    private JLabel lbNome2;
    private JLabel lbSaldo;
    private JLabel lbSaldo2;

    /** Creates new form Saldo */
    public SaldoView() {
        initComponents();
        
        SessaoApp sessaoApp = SessaoApp.getSessaoApp();
        Cliente cliente = sessaoApp.getUsuarioLogado();
        
        System.out.println("Cliente: " + cliente);
        String msg = geraMsg(cliente.getNumConta());
        
        lbConta2.setText(cliente.getNumConta().toString());
        lbNome2.setText(cliente.getNome());

        String resposta = null;
        ConexaoServidor conexao = new ConexaoServidorUDP(sessaoApp);
        try {
            resposta = conexao.comunicaServidor(msg, null);
        	System.out.println("Respota do servidor: " + resposta);
        } catch (ConexaoException exc){
			JOptionPane.showMessageDialog(null, exc.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			return;
		}
        
		lbSaldo2.setText(resposta);
		
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataHojeAsString = formato.format(new Date());
        lbData2.setText(dataHojeAsString);
        
//        lbConta2.setText(banco.cliente.deprecated.Login.cliConta.toString());
//        lbNome2.setText(banco.cliente.deprecated.Login.cliNome.toString());
//        CliThread saldo = new CliThread();
//        String retorno = saldo.comunicaServidor(msg, banco.cliente.deprecated.Login.cliServidor.toString());
//        lbSaldo2.setText(retorno);
//        Date dt = new Date();
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        String dataHojeAsString = formato.format(dt);
//        lbData2.setText(dataHojeAsString);
    }

	private String geraMsg(String numConta) {
		String msg = TipoComando.SALDO.getComando() + " ";
		msg += String.format("select saldo from clientes where conta='%s'", numConta);
		return msg;
	}

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lbNome = new JLabel();
        lbSaldo = new JLabel();
        lbNome2 = new JLabel();
        lbSaldo2 = new JLabel();
        lbData = new JLabel();
        lbData2 = new JLabel();
        lbConta = new JLabel();
        lbConta2 = new JLabel();
        btnOk = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Saldo");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lbNome.setText("Nome:");

        lbSaldo.setText("Saldo: ");

        lbNome2.setText("Nome Comleto");

        lbSaldo2.setText("Saldo da conta");

        lbData.setText("Data: ");

        lbData2.setText("Dia");

        lbConta.setText("Número da conta: ");

        lbConta2.setText("Número da conta");

        btnOk.setText("OK");
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOkMouseClicked(evt);
            }
        });
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        configuraLayout();
    }// </editor-fold>//GEN-END:initComponents

	private void configuraLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbConta)
                    .addComponent(lbData)
                    .addComponent(lbSaldo)
                    .addComponent(lbNome))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbSaldo2)
                    .addComponent(lbData2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbConta2)
                    .addComponent(lbNome2))
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(lbNome2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSaldo)
                    .addComponent(lbSaldo2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbData)
                    .addComponent(lbData2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lbConta)
                    .addComponent(lbConta2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addContainerGap())
        );

        pack();
	}

    private void btnOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseClicked
        dispose();
    }//GEN-LAST:event_btnOkMouseClicked

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    public JLabel getLbConta2() {
        return lbConta2;
    }

    public void setLbConta2(JLabel lbConta2) {
        this.lbConta2 = lbConta2;
    }

    public JLabel getLbData2() {
        return lbData2;
    }

    public void setLbData2(JLabel lbData2) {
        this.lbData2 = lbData2;
    }

    public JLabel getLbNome2() {
        return lbNome2;
    }

    public void setLbNome2(JLabel lbNome2) {
        this.lbNome2 = lbNome2;
    }

    public JLabel getLbSaldo2() {
        return lbSaldo2;
    }

    public void setLbSaldo2(JLabel lbSaldo2) {
        this.lbSaldo2 = lbSaldo2;
    }


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Saque.java
 *
 * Created on 05/09/2010, 16:40:07
 */

package banco.cliente.view;

import javax.swing.*;

import java.awt.event.*;

import banco.cliente.controller.ConexaoException;
import banco.cliente.modelo.Cliente;
import banco.cliente.modelo.conexao.ConexaoServidor;
import banco.cliente.modelo.conexao.ConexaoServidorUDP;
import banco.cliente.modelo.conexao.ServidorIndisponivelException;
import banco.cliente.util.SessaoApp;
import banco.cliente.util.TipoComando;

/**
 *
 * @author usuariio
 */
public class MovimentacaoView extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7183026706191942898L;
	private JButton btnCancelar;
    private JButton btnConfirmar;
    private JComboBox jComboBox1;
    private JLabel jLabel3;
    private JLabel lbMovimentacao;
    private JLabel lbNome;
    private JLabel lbNome2;
    private JLabel lbSaldo;
    private JLabel lbSaldo2;
    private JLabel lbValor;
    private JTextField tfValor;
	private Cliente cliente;
    
    /** Creates new form Saque */
    public MovimentacaoView() {
        initComponents();
        
        SessaoApp sessao = SessaoApp.getSessaoApp();
        this.cliente = sessao.getUsuarioLogado();
        
        lbNome2.setText(cliente.getNome());
        
        String msg = geraMsgVerSaldo(cliente.getNumConta());
        
        String saldo = null;
        ConexaoServidor conexao = new ConexaoServidorUDP(sessao);
        try {
            saldo = conexao.comunicaServidor(msg, null);
        	System.out.println("Respota do servidor: " + saldo);
        } catch (ConexaoException exc){
			JOptionPane.showMessageDialog(null, exc.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			return;
		}
        
		lbSaldo2.setText(saldo);
		cliente.setSaldo(saldo);
    }

    private String geraMsgVerSaldo(String numConta) {
    	String msg = TipoComando.SALDO.getComando() + " ";
		msg += String.format("select saldo from clientes where conta='%s'", numConta);
		return msg;
	}

    private void initComponents() {

        jLabel3 = new JLabel();
        lbMovimentacao = new JLabel();
        lbValor = new JLabel();
        tfValor = new JTextField();
        btnConfirmar = new JButton();
        btnCancelar = new JButton();
        jComboBox1 = new JComboBox();
        lbNome = new JLabel();
        lbNome2 = new JLabel();
        lbSaldo = new JLabel();
        lbSaldo2 = new JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimenta��es");
        setResizable(false);

        lbMovimentacao.setText("Movimenta��o: ");

        lbValor.setText("Valor: ");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Saque", "Dep�sito" }));

        lbNome.setText("Nome:");

        lbNome2.setText("Nome Completo");

        lbSaldo.setText("Saldo: ");

        lbSaldo2.setText("Saldo");

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
                    .addComponent(lbMovimentacao)
                    .addComponent(lbSaldo)
                    .addComponent(lbValor)
                    .addComponent(lbNome))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbNome2)
                    .addComponent(tfValor, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(lbSaldo2)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox1, 0, 158, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnConfirmar)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar))))
                .addContainerGap(49, Short.MAX_VALUE))
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
                    .addComponent(lbMovimentacao)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValor))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
	}

    public JLabel getLbMovimentacao() {
        return lbMovimentacao;
    }

    public void setLbMovimentacao(JLabel lbMovimentacao) {
        this.lbMovimentacao = lbMovimentacao;
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

    public JTextField getTfValor() {
        return tfValor;
    }

    public void setTfValor(JTextField tfValor) {
        this.tfValor = tfValor;
    }

    private void btnCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        String msgAlterarSaldo = "";
        
        String valor = tfValor.getText().trim();
        if(!isValido(valor)){
            JOptionPane.showMessageDialog(null, "Campo Valor em branco.", "Erro!", JOptionPane.OK_OPTION);
        }else {
            String tipoMov = jComboBox1.getSelectedItem().equals("Saque") ? "Saque" : "Deposito";
            msgAlterarSaldo = geraMsgAlteraSaldo(tipoMov,valor);
            
            String resposta = null;
            ConexaoServidor conexao = new ConexaoServidorUDP(SessaoApp.getSessaoApp());
            try {
                
            	resposta = conexao.comunicaServidor(msgAlterarSaldo, null);
            	System.out.println("Resposta do servidor: " + resposta);
            
            	if (resposta.equals(TipoComando.ERRO.getComando())){
    				JOptionPane.showMessageDialog(null, "Falha na Opera��o!", "Erro!", JOptionPane.ERROR_MESSAGE);
    				return;
    			}
            	
            	String msgAddMovimentacao = geraAddMovimentacao(tipoMov,valor);
            	resposta = conexao.comunicaServidor(msgAddMovimentacao, null);
            
            	if (resposta.equals(TipoComando.ERRO.getComando())){
    				JOptionPane.showMessageDialog(null, "Falha na Opera��o!", "Erro!", JOptionPane.ERROR_MESSAGE);
    				return;
    			}
            
            } catch (ConexaoException exc){
    			JOptionPane.showMessageDialog(null, "Falha na Opera��o" + exc.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
    			return;
    		} catch (ServidorIndisponivelException exc){
    			JOptionPane.showMessageDialog(null, "Falha na Opera��o ->" + exc.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
    			return;
    		} 
                                    
            JOptionPane.showMessageDialog(null, "Opera��o realizada com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

	private String geraAddMovimentacao(String tipoMov, String valor) {
		String msg = TipoComando.ADD_MOVIMENTACAO + " ";
		
		String val = "";
		if (tipoMov.equals("Saque")){
			val = "-" + valor;
		} else {
			val = "+" + valor;
		}
		
		msg += String.format("insert into movimentacoes (idconta,tipo,valor,saldoanterior) values (%s,'%s',%s,%s)",
							cliente.getNumConta(),tipoMov,val,cliente.getSaldo());
		return msg;
	}

	private String geraMsgAlteraSaldo(String tipo, String valor) {
		
		String msg = TipoComando.DEPOSITO_SAQUE + " ";
		
		String val = "";
		if (tipo.equals("Saque")){
			val = "-" + valor;
		} else {
			val = "+" + valor;
		}
		
		msg += String.format("update clientes set saldo = saldo %s where conta=%s",
							val, cliente.getNumConta());
		return msg;
	}

	private boolean isValido(String valor) {
		return !valor.isEmpty();
	}
	

}

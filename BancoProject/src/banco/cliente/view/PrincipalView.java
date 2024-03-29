/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 05/09/2010, 15:34:11
 */

package banco.cliente.view;

import javax.swing.*;

import banco.cliente.util.MonitoradorStatus;
import banco.cliente.util.SessaoApp;
import banco.cliente.util.StatusBar;

import java.awt.BorderLayout;
import java.awt.event.*;
/**
 *
 * @author usuariio
 */
public class PrincipalView extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3291605874691270804L;
	private JMenu MenuArquivo;
    private JMenuItem MenuBusca;
    private JMenu MenuConsulta;
    private JMenu MenuMovimentacoes;
    private JMenuItem MenuMovimento;
    private JMenuBar MenuPrincipal;
    private JMenuItem MenuSair;
    private JMenuItem MenuSaldo;
	private StatusBar statusBar;
    
    /** Creates new form Principal */
    public PrincipalView() {
        initComponents();
        if(!SessaoApp.getSessaoApp().getUsuarioLogado().getNome().equals("Administrador")){
//        if(!banco.cliente.deprecated.Login.cliServidor.equals("Administrador")){
            MenuBusca.setVisible(false);
        }else {
            MenuMovimentacoes.setVisible(false);
            MenuSaldo.setVisible(false);
            MenuMovimento.setVisible(false);
        }
        
        MonitoradorStatus monitorador = new MonitoradorStatus(statusBar);
        
        Thread threadMonitoramento = new Thread(monitorador);
        threadMonitoramento.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        MenuPrincipal = new JMenuBar();
        MenuArquivo = new JMenu();
        MenuSair = new JMenuItem();
        MenuBusca = new JMenuItem();
        MenuConsulta = new JMenu();
        MenuSaldo = new JMenuItem();
        MenuMovimentacoes = new JMenu();
        MenuMovimento = new JMenuItem();
        statusBar = new StatusBar("Status do Servidor:");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        MenuArquivo.setText("Arquivo");

        MenuSair.setText("Sair");
        MenuSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        MenuArquivo.add(MenuSair);

        MenuPrincipal.add(MenuArquivo);


        MenuBusca.setText("Busca ");

        MenuConsulta.setText("Consulta");

        MenuSaldo.setText("Saldo");
        MenuSaldo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                menuSaldoMouseClicked(evt);
            }
        });
        MenuSaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuSaldoActionPerformed(evt);
            }
        });
        MenuConsulta.add(MenuSaldo);

        MenuPrincipal.add(MenuConsulta);

        MenuMovimentacoes.setText("Movimentações");
        MenuMovimentacoes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                menuMovimentacoesMouseClicked(evt);
            }
        });

        MenuMovimento.setText("Saque/Depósito");
        MenuMovimento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuMovimentoActionPerformed(evt);
            }
        });
        MenuMovimentacoes.add(MenuMovimento);

        MenuPrincipal.add(MenuMovimentacoes);

        setJMenuBar(MenuPrincipal);

        setSize(400,400);
        setLayout(new BorderLayout());
        add(statusBar,BorderLayout.SOUTH);
        
        
    }// </editor-fold>//GEN-END:initComponents


    private void menuSaldoMouseClicked(MouseEvent evt) {//GEN-FIRST:event_MenuSaldoMouseClicked
        
    }//GEN-LAST:event_MenuSaldoMouseClicked

    private void menuMovimentacoesMouseClicked(MouseEvent evt) {//GEN-FIRST:event_MenuMovimentacoesMouseClicked
        
    }//GEN-LAST:event_MenuMovimentacoesMouseClicked

    private void menuSairActionPerformed(ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuSairActionPerformed

    private void menuSaldoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_MenuSaldoActionPerformed
        SaldoView saldo = new SaldoView();
        saldo.setLocationRelativeTo(null);
        saldo.setVisible(true);
    }//GEN-LAST:event_MenuSaldoActionPerformed

    private void menuMovimentoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_MenuMovimentoActionPerformed
        MovimentacaoView mov = new MovimentacaoView();
        mov.setLocationRelativeTo(null);
        mov.setVisible(true);
    }


}

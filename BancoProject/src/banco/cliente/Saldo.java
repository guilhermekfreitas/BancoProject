/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Saldo.java
 *
 * Created on 07/09/2010, 15:01:09
 */

package banco.cliente;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class Saldo extends javax.swing.JFrame {

    /** Creates new form Saldo */
    public Saldo() {
        initComponents();
        String msg = "6 "+banco.cliente.Login.cliConta;
        lbConta2.setText(banco.cliente.Login.cliConta.toString());
        lbNome2.setText(banco.cliente.Login.cliNome.toString());
        CliThread saldo = new CliThread();
        String retorno = saldo.ComunicaServidor(msg, banco.cliente.Login.cliServidor.toString());
        lbSaldo2.setText(retorno);
        Date dt = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataHojeAsString = formato.format(dt);
        lbData2.setText(dataHojeAsString);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNome = new javax.swing.JLabel();
        lbSaldo = new javax.swing.JLabel();
        lbNome2 = new javax.swing.JLabel();
        lbSaldo2 = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbData2 = new javax.swing.JLabel();
        lbConta = new javax.swing.JLabel();
        lbConta2 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbConta)
                    .addComponent(lbData)
                    .addComponent(lbSaldo)
                    .addComponent(lbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSaldo2)
                    .addComponent(lbData2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbConta2)
                    .addComponent(lbNome2))
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(lbNome2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSaldo)
                    .addComponent(lbSaldo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbData)
                    .addComponent(lbData2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbConta)
                    .addComponent(lbConta2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lbConta;
    private javax.swing.JLabel lbConta2;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbData2;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNome2;
    private javax.swing.JLabel lbSaldo;
    private javax.swing.JLabel lbSaldo2;
    // End of variables declaration//GEN-END:variables

}

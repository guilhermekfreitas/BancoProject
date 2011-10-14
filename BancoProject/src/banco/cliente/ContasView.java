/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Contas.java
 *
 * Created on 19/09/2010, 18:47:04
 */

package banco.cliente;

import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author usuariio
 */
public class ContasView extends JFrame {

    private JButton btnOk;
    private JScrollPane jScrollPane1;
    private JLabel lbCliente;
    private JTable tabela;
	
    /** Creates new form Contas */
    public ContasView() {
        initComponents();
        String msg = "5";
        String resposta = "";
        String retorno = "";
        int linha = 1;
        while(!resposta.equals("0")){
            //manda msg para o servidor
            CliThread consulta = new CliThread();
            retorno = consulta.comunicaServidor(msg, banco.cliente.deprecated.Login.servidorA);
            //quando resposta for igual a zero , quer dizer que acabaram as contas
            resposta = retorno;

            int tam = retorno.length();
            char palavra[]=retorno.toCharArray();
            int cont = 2;
            int inicio = 0;
            for (int i = 1; i<=2 ;i++){
                inicio = cont;
                while (palavra[cont]!= ' '){
                    cont++;
                    if (cont == tam){
                        break;
                    }
                }
                //desmembra a mensagem e coloca nos campos da tabela
                switch(i){
                    case 1:{//conta
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 1);
                            cont++;
                           }
                    case 2:{//Nome
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 2);
                            cont++;
                           }
                    case 3:{//CPF
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 3);
                            cont++;
                           }
                    case 4:{//RG
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 4);
                            cont++;
                          }
                    case 5:{//Data de nascimento
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 5);
                            cont++;
                           }
                    case 6:{//Login
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 6);
                            cont++;
                           }
                    case 7:{//senha
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 7);
                            cont++;
                           }
                    case 8:{//saldo
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 8);
                            cont++;
                            }
                }
            }
           linha++;
        }
        while(!resposta.equals("0")){
            //manda msg para o servidor
            CliThread consulta = new CliThread();
            retorno = consulta.comunicaServidor(msg, banco.cliente.deprecated.Login.servidorB);
            //quando resposta for igual a zero , quer dizer que acabaram as contas
            resposta = retorno;

            int tam = retorno.length();
            char palavra[]=retorno.toCharArray();
            int cont = 2;
            int inicio = 0;
            for (int i = 1; i<=2 ;i++){
                inicio = cont;
                while (palavra[cont]!= ' '){
                    cont++;
                    if (cont == tam){
                        break;
                    }
                }
                //desmembra a mensagem e coloca nos campos da tabela
                switch(i){
                    case 1:{//conta
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 1);
                            cont++;
                           }
                    case 2:{//Nome
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 2);
                            cont++;
                           }
                    case 3:{//CPF
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 3);
                            cont++;
                           }
                    case 4:{//RG
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 4);
                            cont++;
                          }
                    case 5:{//Data de nascimento
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 5);
                            cont++;
                           }
                    case 6:{//Login
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 6);
                            cont++;
                           }
                    case 7:{//senha
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 7);
                            cont++;
                           }
                    case 8:{//saldo
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 8);
                            cont++;
                            }
                }
            }
           linha++;
        }
        while(!resposta.equals("0")){
            //manda msg para o servidor
            CliThread consulta = new CliThread();
            retorno = consulta.comunicaServidor(msg, banco.cliente.deprecated.Login.servidorC);
            //quando resposta for igual a zero , quer dizer que acabaram as contas
            resposta = retorno;

            int tam = retorno.length();
            char palavra[]=retorno.toCharArray();
            int cont = 2;
            int inicio = 0;
            for (int i = 1; i<=2 ;i++){
                inicio = cont;
                while (palavra[cont]!= ' '){
                    cont++;
                    if (cont == tam){
                        break;
                    }
                }
                //desmembra a mensagem e coloca nos campos da tabela
                switch(i){
                    case 1:{//conta
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 1);
                            cont++;
                           }
                    case 2:{//Nome
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 2);
                            cont++;
                           }
                    case 3:{//CPF
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 3);
                            cont++;
                           }
                    case 4:{//RG
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 4);
                            cont++;
                          }
                    case 5:{//Data de nascimento
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 5);
                            cont++;
                           }
                    case 6:{//Login
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 6);
                            cont++;
                           }
                    case 7:{//senha
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 7);
                            cont++;
                           }
                    case 8:{//saldo
                            tabela.setValueAt(retorno.substring(inicio, cont-1), linha, 8);
                            cont++;
                            }
                }
            }
           linha++;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOk = new JButton();
        lbCliente = new JLabel();
        jScrollPane1 = new JScrollPane();
        tabela = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        btnOk.setText("ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        lbCliente.setText("Clientes: ");

        tabela.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Conta", "Nome", "CPF", "RG", "Data nasc.", "Login", "Senha", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

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
                    .addComponent(lbCliente)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                    .addComponent(btnOk, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCliente)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
	}

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        dispose();
}//GEN-LAST:event_btnOkActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContasView().setVisible(true);
            }
        });
    }


}

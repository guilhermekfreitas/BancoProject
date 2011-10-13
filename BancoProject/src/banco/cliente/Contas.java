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

/**
 *
 * @author usuariio
 */
public class Contas extends javax.swing.JFrame {

    /** Creates new form Contas */
    public Contas() {
        initComponents();
        String msg = "5";
        String resposta = "";
        String retorno = "";
        int linha = 1;
        while(!resposta.equals("0")){
            //manda msg para o servidor
            CliThread consulta = new CliThread();
            retorno = consulta.ComunicaServidor(msg, banco.cliente.Login.servidorA);
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
            retorno = consulta.ComunicaServidor(msg, banco.cliente.Login.servidorB);
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
            retorno = consulta.ComunicaServidor(msg, banco.cliente.Login.servidorC);
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

        btnOk = new javax.swing.JButton();
        lbCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnOk.setText("ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        lbCliente.setText("Clientes: ");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCliente)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                    .addComponent(btnOk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        dispose();
}//GEN-LAST:event_btnOkActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}

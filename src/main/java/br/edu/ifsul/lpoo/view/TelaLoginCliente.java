
package br.edu.ifsul.lpoo.view;

import br.edu.ifsul.lpoo.control.PersistenciaJPA;
import br.edu.ifsul.lpoo.model.Clientes;
import br.edu.ifsul.lpoo.model.Contas;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jennifer Ebertz
 */
public class TelaLoginCliente extends javax.swing.JFrame {

    PersistenciaJPA jpa;
    Clientes cliente = null;
    /**
     * Creates new form TelaLoginCliente
     */
    public TelaLoginCliente() {
        jpa = new PersistenciaJPA();
        initComponents();
        setLocationRelativeTo(null); 
    }
    
    /**
     * Localiza o cliente proprietário da conta encontrada anteriormente.
     * Assume que 'this.conta' já foi preenchida com uma conta válida.
     * Atribui o cliente encontrado à variável de instância 'this.cliente'.
     * @return true se o cliente for encontrado, false caso contrário.
     */
    public boolean localizaCliente() {
        boolean existe = false;

        String loginUser = txtLoginUser.getText();
        
        if (loginUser.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um Usuário válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        List<Clientes> listaClientes = jpa.getClientes();

        if (listaClientes != null) {
            
            for (Clientes c : listaClientes) {
                
                if (loginUser.equals(c.getLogin())) {
                    existe = true; 
                    cliente = c;
                    break; 
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao carregar lista de Clientes. Verifique o console.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: jpa.getClientes() retornou null.");
        }
        return existe;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblnumeroConta = new javax.swing.JLabel();
        txtLoginUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSenhaC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Login Cliente");

        lblnumeroConta.setText("Login Usuario:");

        jLabel1.setText("Senha do Usuário:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Login no Caixa Eletronico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(68, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLoginUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSenhaC)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lblnumeroConta)
                                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblnumeroConta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLoginUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenhaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           if(localizaCliente()){
            if(txtSenhaC.getText().equals(cliente.getSenha())){
            CaixaEletronicoJF caixa = new CaixaEletronicoJF();
            caixa.setCliente(cliente);
            caixa.setVisible(true);

            dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Senha Inválida!!", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            }
        }else{
        JOptionPane.showMessageDialog(this, "Usuário Não Encontrado!!", "Erro de Login", JOptionPane.ERROR_MESSAGE);
    }
    
    
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLoginCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblnumeroConta;
    private javax.swing.JTextField txtLoginUser;
    private javax.swing.JTextField txtSenhaC;
    // End of variables declaration//GEN-END:variables
}

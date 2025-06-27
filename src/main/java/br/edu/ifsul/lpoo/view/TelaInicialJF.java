/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifsul.lpoo.view;

import br.edu.ifsul.lpoo.control.PersistenciaJPA;
import br.edu.ifsul.lpoo.model.Funcionarios;
import java.util.List; // Importar List para usar com jpa.getFuncionarios()
import javax.swing.JOptionPane; // Para exibir mensagens ao usuário

/**
 *
 * @author Jennifer Ebertz
 */
public class TelaInicialJF extends javax.swing.JFrame {

    PersistenciaJPA jpa;
    // Inicializar funcionario como null e atribuir somente se encontrado
    Funcionarios funcionario = null; 
    
    /**
     * Creates new form TelaInicialJF
     */
    public TelaInicialJF() {
        jpa = new PersistenciaJPA(); // Inicializa a camada de persistência
        initComponents(); // Inicializa os componentes da interface gráfica
        // Configura a janela para centralizar na tela
        setLocationRelativeTo(null); 
    }
    
    /**
     * Localiza um funcionário na lista de funcionários retornada pela JPA
     * com base no número do crachá digitado.
     * @return true se o funcionário for encontrado, false caso contrário.
     */
    public boolean localizaFuncionarios() {
        boolean existe = false;
        
        // Obtém o número do crachá digitado pelo usuário
        String nCrachaDigitado = txtNCracha.getText();
        
        // Verifica se o campo do crachá não está vazio
        if (nCrachaDigitado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite o número do crachá.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false; // Retorna falso se o campo estiver vazio
        }

        // Obtém a lista de funcionários do banco de dados
        List<Funcionarios> listaFuncionarios = jpa.getFuncionarios();

        // Verifica se a lista de funcionários não é nula (erro na persistência)
        if (listaFuncionarios != null) {
            // Itera sobre a lista de funcionários para encontrar uma correspondência
            for (Funcionarios f : listaFuncionarios) {
                // Compara o texto digitado no campo com o número do crachá do funcionário
                if (nCrachaDigitado.equals(f.getnCracha())) {
                    existe = true; // Funcionário encontrado
                    funcionario = f; // Atribui o funcionário encontrado à variável global
                    break; // Sai do loop assim que encontrar o funcionário
                }
            }
        } else {
            // Mensagem de erro se a lista de funcionários não puder ser carregada
            JOptionPane.showMessageDialog(this, "Erro ao carregar lista de funcionários. Verifique o console.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erro: jpa.getFuncionarios() retornou null.");
        }
        return existe;
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        btnLogin = new javax.swing.JToggleButton();
        lblNCracha = new javax.swing.JLabel();
        txtNCracha = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblLogin.setText("Login Usuários");
        lblLogin.setToolTipText("");
        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblNCracha.setText("Número do Cracha:");

        txtNCracha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNCrachaActionPerformed(evt);
            }
        });

        lblSenha.setText("Senha:");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNCracha))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNCracha, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenha))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNCracha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNCracha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    if(localizaFuncionarios()){
            if(txtSenha.getText().equals(funcionario.getSenha())){
            TelaFuncionariosJF telaFunc = new TelaFuncionariosJF();
            telaFunc.setVisible(true); 
            telaFunc.setFuncionario(funcionario);
            dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Senha Inválida!!", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Funcionário Não Encontrado!!", "Erro de Login", JOptionPane.ERROR_MESSAGE);    
        }
    
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtNCrachaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNCrachaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNCrachaActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicialJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicialJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicialJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicialJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicialJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnLogin;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNCracha;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtNCracha;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables

}

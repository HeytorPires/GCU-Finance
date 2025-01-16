/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.CRUD;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.CategoriaDespesa;
import model.bean.CategoriaReceita;
import model.dao.CategoriaDespesaDAO;
import view.TelaMenuPrincipal;
/**
 *
 * @author heyto
 */
public class TelaCategoriaDespesaCRUD extends javax.swing.JFrame {

    /**
     * Creates new form TelaCategoriaCRUD
     */
    private int id_usuario;
     public TelaCategoriaDespesaCRUD(int id_usuario) throws ClassNotFoundException, SQLException {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null );

        this.id_usuario = id_usuario;
         try {
            readJtable();
        } catch (SQLException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private TelaCategoriaDespesaCRUD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void readJtable() throws  ClassNotFoundException, SQLException {
        DefaultTableModel modelo = (DefaultTableModel) TabelaExibir.getModel();
        modelo.setNumRows(0);
        CategoriaDespesaDAO pdao = new CategoriaDespesaDAO();
        pdao.readCategoriaByIdUser(id_usuario).stream().forEach((c) -> {
            modelo.addRow(new Object[]{
                c.getId_categoria_despesa(),
                c.getNome(),
                c.getDescricao(),
                c.getCode()
            });
        });
    }
    
    public void readJtableForDesc(String titulo, int id_usuario) throws SQLException, ClassNotFoundException  {
    DefaultTableModel modelo = (DefaultTableModel) TabelaExibir.getModel();
    modelo.setNumRows(0);
    CategoriaDespesaDAO pdao = new CategoriaDespesaDAO();


    pdao.readForDesc(titulo, id_usuario).stream().forEach((c) -> {
        modelo.addRow(new Object[]{
            c.getId_categoria_despesa(),
                c.getNome(),
                c.getDescricao(),
                c.getCode()
        });
    });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InputTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaExibir = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        BotaoExcluir = new javax.swing.JButton();
        InputPesquisa = new javax.swing.JTextField();
        BotaoCadastrar = new javax.swing.JButton();
        buttonPesquisa = new javax.swing.JButton();
        BotaoAtualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        InputCode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        InputDescricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Categoria Despesa");
        setResizable(false);

        jLabel1.setText("titulo");

        TabelaExibir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descrição", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaExibir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaExibirKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaExibir);

        jLabel3.setText("Descricao");

        BotaoExcluir.setText("Excluir");
        BotaoExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BotaoExcluirMouseReleased(evt);
            }
        });
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        InputPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPesquisaActionPerformed(evt);
            }
        });

        BotaoCadastrar.setText("Cadastrar");
        BotaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarActionPerformed(evt);
            }
        });

        buttonPesquisa.setText("Buscar");
        buttonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisaActionPerformed(evt);
            }
        });

        BotaoAtualizar.setText("Atualizar");
        BotaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAtualizarActionPerformed(evt);
            }
        });

        jLabel4.setText("Pesquisa");

        jLabel5.setText("Código");

        botaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/door_out.png"))); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        InputDescricao.setColumns(20);
        InputDescricao.setRows(5);
        jScrollPane2.setViewportView(InputDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotaoCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(BotaoExcluir))
                            .addComponent(InputTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(BotaoAtualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(InputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                        .addComponent(buttonPesquisa))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(InputCode, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(InputCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonPesquisa)))
                    .addComponent(InputTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoExcluir)
                    .addComponent(BotaoAtualizar)
                    .addComponent(BotaoCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BotaoExcluir.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaExibirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaExibirKeyReleased

        if (TabelaExibir.getSelectedRow() != -1) {
            InputTitulo.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 1).toString());
            InputDescricao.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 2).toString());
            InputCode.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_TabelaExibirKeyReleased

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed

        if (TabelaExibir.getSelectedRow() != -1) {
           int id_categoriaDespesa = ((int)TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 0));
           int antigoCode = (int) TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 3);

            try {
                if(Controller.CategoriaDespesaController.Delete(id_categoriaDespesa, id_usuario, antigoCode)){
                      InputTitulo.setText("");
                        InputDescricao.setText("");
                        InputPesquisa.setText("");
                        InputCode.setText("");
                        readJtable();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void InputPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPesquisaActionPerformed

    private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarActionPerformed

         String Titulo = InputTitulo.getText();
        String Descricao = InputDescricao.getText();
        int code ;

        try {
            code = Integer.parseInt(InputCode.getText()); // Converter o input para double
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um código válido");
            return; 
        }
        try {
            if(Controller.CategoriaDespesaController.Create(Titulo, Descricao, code, id_usuario)){
                InputTitulo.setText("");
                InputDescricao.setText("");
                InputCode.setText("");
                readJtable();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCategoriaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCategoriaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCadastrarActionPerformed

    private void buttonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisaActionPerformed

        try {
            readJtableForDesc(InputPesquisa.getText(), id_usuario);
        } catch (SQLException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonPesquisaActionPerformed

    private void BotaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizarActionPerformed

        if (TabelaExibir.getSelectedRow() != -1) {
        int antigoCode = (int) TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 3);
        String Titulo = InputTitulo.getText();
        String Descricao = InputDescricao.getText();
        int code ;
        try {
            code = Integer.parseInt(InputCode.getText()); // Converter o input para double
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um código válido");
            return; 
        }
        try {
            if(Controller.CategoriaDespesaController.Update(Titulo, Descricao, code, antigoCode, id_usuario)){
                InputTitulo.setText("");
                InputDescricao.setText("");
                InputCode.setText("");
                readJtable();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCategoriaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCategoriaDespesaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_BotaoAtualizarActionPerformed

    private void BotaoExcluirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirMouseReleased
        
    }//GEN-LAST:event_BotaoExcluirMouseReleased

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
         int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                new TelaMenuPrincipal(id_usuario).setVisible(true);
                this.dispose(); 
                }
    }//GEN-LAST:event_botaoSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCategoriaDespesaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaDespesaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaDespesaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaDespesaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCategoriaDespesaCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAtualizar;
    private javax.swing.JButton BotaoCadastrar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JTextField InputCode;
    private javax.swing.JTextArea InputDescricao;
    private javax.swing.JTextField InputPesquisa;
    private javax.swing.JTextField InputTitulo;
    private javax.swing.JTable TabelaExibir;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton buttonPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

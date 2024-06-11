/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao.CRUD;
import java.lang.System.Logger;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Receita;
import model.dao.ReceitaDAO;
import visao.TelaMenuPrincipal;
/**
 *
 * @author heyto
 */
public class TelaReceitaCRUD extends javax.swing.JFrame {

    /**
     * Creates new form TelaReceitaCRUD
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    private int id_usuario;

    public TelaReceitaCRUD(int id_usuario) throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo( null );

        this.id_usuario = id_usuario;
         try {
            readJtable();
        } catch (SQLException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private TelaReceitaCRUD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void readJtable() throws  ClassNotFoundException, SQLException {
        DefaultTableModel modelo = (DefaultTableModel) TabelaExibir.getModel();
        modelo.setNumRows(0);
        ReceitaDAO pdao = new ReceitaDAO();

        pdao.readReceitaByIdUser(id_usuario).stream().forEach((d) -> {
            modelo.addRow(new Object[]{
                d.getId_receita(),
                d.getTitulo(),
                d.getValor(),
                d.getData(),
                d.getCode()
            });
        });
    }
    
    
    public void readJtableForDesc(String titulo, int id_usuario) throws SQLException, ClassNotFoundException  {
    DefaultTableModel modelo = (DefaultTableModel) TabelaExibir.getModel();
    modelo.setNumRows(0);
    ReceitaDAO pdao = new ReceitaDAO();


    pdao.readForDesc(titulo, id_usuario).stream().forEach((d) -> {
        modelo.addRow(new Object[]{
            d.getId_receita(),
                d.getTitulo(),
                d.getValor(),
                d.getData(),
                d.getCode()
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaExibir = new javax.swing.JTable();
        BotaoExcluir = new javax.swing.JButton();
        InputPesquisa = new javax.swing.JTextField();
        BotaoCadastrar = new javax.swing.JButton();
        buttonPesquisa = new javax.swing.JButton();
        BotaoAtualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        InputTitulo = new javax.swing.JTextField();
        InputValor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();
        inputcode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Inputdata = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 550));

        TabelaExibir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Valor", "Data", "Cod. Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        BotaoExcluir.setText("Excluir");
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

        jLabel1.setText("titulo");

        jLabel3.setText("valor");

        botaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/door_out.png"))); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        jLabel5.setText("Data");

        jLabel6.setText("Code");

        Inputdata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("Y-MM-dd"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(InputTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(147, 147, 147)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputValor)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(93, 93, 93)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Inputdata, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(inputcode, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoExcluir)
                        .addGap(30, 30, 30)
                        .addComponent(BotaoAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(InputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonPesquisa))
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InputTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Inputdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoExcluir)
                        .addComponent(BotaoAtualizar)
                        .addComponent(BotaoCadastrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(InputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonPesquisa)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaExibirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaExibirKeyReleased

        if (TabelaExibir.getSelectedRow() != -1) {
            InputTitulo.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 1).toString());
            InputValor.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 2).toString());
            Inputdata.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 3).toString());
            inputcode.setText(TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_TabelaExibirKeyReleased

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed

        if (TabelaExibir.getSelectedRow() != -1) {
            Receita r = new Receita();
            ReceitaDAO dao = new ReceitaDAO();

            r.setId_receita((int) TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 0));

            InputTitulo.setText("");
            InputValor.setText("");
            Inputdata.setText("");
            inputcode.setText("");
           
            try {
                dao.delete(r);
                readJtable();

            } catch (ClassNotFoundException | SQLException ex) {
                java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void InputPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPesquisaActionPerformed

    private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarActionPerformed

        Receita r = new Receita();
        ReceitaDAO dao = new ReceitaDAO();

        r.setTitulo(InputTitulo.getText());
        r.setValor(Double.parseDouble(InputValor.getText()));
        r.setId_usuario(id_usuario);
        r.setData(java.sql.Date.valueOf(Inputdata.getText()));
       // r.setData(Date.valueOf(Inputdata.getText()));
        r.setCode(Integer.parseInt(inputcode.getText()));
        InputTitulo.setText("");
        InputValor.setText("");
        Inputdata.setText("");
        inputcode.setText("");
       
        try {
            dao.Create(r);
            readJtable();

        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
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
            Receita r = new Receita();
            ReceitaDAO dao = new ReceitaDAO();

            r.setTitulo(InputTitulo.getText());
            r.setValor(Double.parseDouble(InputValor.getText()));
            r.setId_usuario(id_usuario);
            r.setId_receita((int) TabelaExibir.getValueAt(TabelaExibir.getSelectedRow(), 0));
            r.setData(java.sql.Date.valueOf(Inputdata.getText()));
            r.setCode(Integer.parseInt(inputcode.getText()));
            
            InputTitulo.setText("");
            InputValor.setText("");
            Inputdata.setText("");
            inputcode.setText("");
            InputPesquisa.setText("");

            try {
                dao.update(r);
                readJtable();

            } catch (ClassNotFoundException | SQLException ex) {
                java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BotaoAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReceitaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaReceitaCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAtualizar;
    private javax.swing.JButton BotaoCadastrar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JTextField InputPesquisa;
    private javax.swing.JTextField InputTitulo;
    private javax.swing.JTextField InputValor;
    private javax.swing.JFormattedTextField Inputdata;
    private javax.swing.JTable TabelaExibir;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton buttonPesquisa;
    private javax.swing.JTextField inputcode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
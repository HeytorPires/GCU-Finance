package visao;
import model.Despesa;
import repository.repositorioDespesas;
import javax.swing.DefaultListModel;
import visao.Cadastro.TelaCadastroDespesas;
import visao.Cadastro.TelaCadastroReceita;
import visao.Cadastro.TelaCadastroCategoria;
import visao.Editar.TelaEditarDespesas;
import visao.Editar.TelaEditarReceita;
import visao.Editar.TelaEditarUsuario;
import visao.Editar.TelaEditarCategoria;


public class TelaMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaMenuPrincipal
     */
    public TelaMenuPrincipal() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        ListarDespesas();
    }
    public void ListarDespesas(){
       DefaultListModel model = new DefaultListModel();
       model.clear();
       model.addAll(repository.repositorioUsuarios.usuarios);
       this.jListDespesas.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListDespesas = new javax.swing.JList<>();
        jButtonEditarDespesa = new javax.swing.JButton();
        jButtonExcluirDespesas = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuCadastroUsuario = new javax.swing.JMenuItem();
        jMenuCadastroDespesas = new javax.swing.JMenuItem();
        jMenuCadastroReceita = new javax.swing.JMenuItem();
        jMenuCadastroCategoria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuEditarDespesas = new javax.swing.JMenuItem();
        jMenuEditarReceita = new javax.swing.JMenuItem();
        jMenuEditarCategoria = new javax.swing.JMenuItem();
        PerfilMenu = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuEditarUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jListDespesas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListDespesas);

        jButtonEditarDespesa.setText("Editar");

        jButtonExcluirDespesas.setText("Excluir");
        jButtonExcluirDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirDespesasActionPerformed(evt);
            }
        });

        jButton3.setText("jButton1");

        jMenu1.setText("Cadastro");

        jMenuCadastroUsuario.setText("Usuario");
        jMenuCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroUsuario);

        jMenuCadastroDespesas.setText("Despesa");
        jMenuCadastroDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroDespesasActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroDespesas);

        jMenuCadastroReceita.setText("Receita");
        jMenuCadastroReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroReceitaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroReceita);

        jMenuCadastroCategoria.setText("Categoria");
        jMenuCadastroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroCategoria);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Editar");

        jMenuEditarDespesas.setText("Despesas");
        jMenuEditarDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarDespesasActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuEditarDespesas);

        jMenuEditarReceita.setText("Receita");
        jMenuEditarReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarReceitaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuEditarReceita);

        jMenuEditarCategoria.setText("Categoria");
        jMenuEditarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarCategoriaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuEditarCategoria);

        jMenuBar1.add(jMenu3);

        PerfilMenu.setText("Perfil");

        jMenuItem6.setText("Visualizar");
        PerfilMenu.add(jMenuItem6);

        jMenuEditarUsuario.setText("Editar");
        jMenuEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarUsuarioActionPerformed(evt);
            }
        });
        PerfilMenu.add(jMenuEditarUsuario);

        jMenuBar1.add(PerfilMenu);

        jMenu2.setText("Sistema");

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEditarDespesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jButtonExcluirDespesas)
                        .addGap(44, 44, 44)
                        .addComponent(jButton3)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditarDespesa)
                    .addComponent(jButton3)
                    .addComponent(jButtonExcluirDespesas))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuCadastroDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroDespesasActionPerformed
        new TelaCadastroDespesas().setVisible(true);
    }//GEN-LAST:event_jMenuCadastroDespesasActionPerformed

    private void jMenuCadastroReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroReceitaActionPerformed
        new TelaCadastroReceita().setVisible(true);
    }//GEN-LAST:event_jMenuCadastroReceitaActionPerformed

    private void jMenuCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroUsuarioActionPerformed
        new TelaCadastroUsuario().setVisible(true);
    }//GEN-LAST:event_jMenuCadastroUsuarioActionPerformed

    private void jMenuEditarReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarReceitaActionPerformed
       new TelaEditarReceita().setVisible(true);
    }//GEN-LAST:event_jMenuEditarReceitaActionPerformed

    private void jMenuEditarDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarDespesasActionPerformed
        new TelaEditarDespesas().setVisible(true);
    }//GEN-LAST:event_jMenuEditarDespesasActionPerformed

    private void jMenuEditarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarCategoriaActionPerformed
        new TelaEditarCategoria().setVisible(true);
    }//GEN-LAST:event_jMenuEditarCategoriaActionPerformed

    private void jMenuEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarUsuarioActionPerformed
        new TelaEditarUsuario().setVisible(true);
    }//GEN-LAST:event_jMenuEditarUsuarioActionPerformed

    private void jMenuCadastroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroCategoriaActionPerformed
        new TelaCadastroCategoria().setVisible(true);
    }//GEN-LAST:event_jMenuCadastroCategoriaActionPerformed

    private void jButtonExcluirDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirDespesasActionPerformed
        int indice = this.jListDespesas.getSelectedIndex();
        if(indice >= 0){
        Despesa despesa = (Despesa) this.jListDespesas.getSelectedValuesList();
        repositorioDespesas.despesas.remove(despesa);
        ListarDespesas();        
        }
    }//GEN-LAST:event_jButtonExcluirDespesasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaMenuPrincipal().setVisible(true);
        });
    }
            
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu PerfilMenu;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonEditarDespesa;
    private javax.swing.JButton jButtonExcluirDespesas;
    private javax.swing.JList<String> jListDespesas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadastroCategoria;
    private javax.swing.JMenuItem jMenuCadastroDespesas;
    private javax.swing.JMenuItem jMenuCadastroReceita;
    private javax.swing.JMenuItem jMenuCadastroUsuario;
    private javax.swing.JMenuItem jMenuEditarCategoria;
    private javax.swing.JMenuItem jMenuEditarDespesas;
    private javax.swing.JMenuItem jMenuEditarReceita;
    private javax.swing.JMenuItem jMenuEditarUsuario;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

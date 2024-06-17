package view;
import view.Perfil.TelaVisualizarUsuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.CategoriaReceita;
import model.bean.Despesa;
import model.bean.Receita;
import model.bean.Usuario;
import model.dao.CategoriaDespesaDAO;
import model.dao.CategoriaReceitaDAO;
import model.dao.DespesaDAO;
import model.dao.MovimentacoesDAO;
import model.dao.ReceitaDAO;
import view.Acesso.TelaLoginUsuario;
import view.Sobre.TelaSobre;
import view.CRUD.TelaCategoriaDespesaCRUD;
import view.CRUD.TelaCategoriaReceitaCRUD;
import view.CRUD.TelaDespesaCRUD;
import view.CRUD.TelaReceitaCRUD;
import view.Perfil.TelaApagarDadosUsuario;
import view.Perfil.TelaEditarSenha;
import view.Perfil.TelaEditarUsuario;



public class TelaMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaMenuPrincipal
     */
      private int id_usuario;

    public TelaMenuPrincipal(int id_usuario) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        this.id_usuario = id_usuario;
        
        

          try {
              readJtableCategoriasDepesas();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              readJtableReceita();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              readJtableDespesa();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              readJtableMovimentacao();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              readJtableCategoriasReceita();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    private TelaMenuPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void readJtableDespesa() throws  ClassNotFoundException, SQLException {
        DefaultTableModel modelo = (DefaultTableModel) TabelaDespesas.getModel();
        modelo.setNumRows(0);
        DespesaDAO Ddao = new DespesaDAO();

        Ddao.readDepesaByIdUser(id_usuario).stream().forEach((d) -> {
            modelo.addRow(new Object[]{
                d.getId_despesa(),
                d.getTitulo(),
                d.getValor(),
                d.getData(),
                d.getCode()
            });
        });
    }
    public void filterJtableDespesa(String year, String month) throws ClassNotFoundException, SQLException {
    DefaultTableModel modelo = (DefaultTableModel) TabelaDespesas.getModel();
    modelo.setNumRows(0);
    DespesaDAO ddao = new DespesaDAO();

    List<Despesa> despesas = ddao.filterByYearAndMonth(year, month, id_usuario);

    despesas.stream().forEach((d) -> {
        modelo.addRow(new Object[]{
            d.getId_despesa(),
            d.getTitulo(),
            d.getValor(),
            d.getData(),
            d.getCode()
        });
    });
}
    public void filterJtableReceita(String year, String month) throws ClassNotFoundException, SQLException {
    DefaultTableModel modelo = (DefaultTableModel) TabelaReceitas.getModel();
    modelo.setNumRows(0);
    ReceitaDAO ddao = new ReceitaDAO();

    List<Receita> receitas = ddao.filterByYearAndMonth(year, month, id_usuario);

    receitas.stream().forEach((d) -> {
        modelo.addRow(new Object[]{
            d.getId_receita(),
            d.getTitulo(),
            d.getValor(),
            d.getData(),
            d.getCode()
        });
    });
}
    
    public void readJtableReceita() throws  ClassNotFoundException, SQLException {
        DefaultTableModel modelo = (DefaultTableModel) TabelaReceitas.getModel();
        modelo.setNumRows(0);
        ReceitaDAO Rdao = new ReceitaDAO();
        Rdao.readReceitaByIdUser(id_usuario).stream().forEach((r) -> {
            modelo.addRow(new Object[]{
                r.getId_receita(),
                r.getTitulo(),
                r.getValor(),
                r.getData(),
                r.getCode()
            });
        });
    }
    
    public  void readJtableCategoriasDepesas() throws  ClassNotFoundException, SQLException {
        DefaultTableModel modelo = (DefaultTableModel) TabelaCategoriaDespesa.getModel();
        modelo.setNumRows(0);
        CategoriaDespesaDAO Cdao = new CategoriaDespesaDAO();

        Cdao.readCategoriaByIdUser(id_usuario).stream().forEach((c) -> {
            modelo.addRow(new Object[]{
                c.getId_categoria_despesa(),
                c.getNome(),
                c.getDescricao(),
                c.getCode(), 
            });
        });
    }
    
    public void readJtableCategoriasReceita() throws  ClassNotFoundException, SQLException {
        DefaultTableModel modelo = (DefaultTableModel) TabelaCategoriaReceita.getModel();
        modelo.setNumRows(0);
        CategoriaReceitaDAO Cdao = new CategoriaReceitaDAO();

        Cdao.readCategoriaByIdUser(id_usuario).stream().forEach((c) -> {
            modelo.addRow(new Object[]{
                c.getId_categoria_receita(),
                c.getNome(),
                c.getDescricao(),
                c.getCode(), 
            });
        });
    }
    public void readJtableMovimentacao() throws  ClassNotFoundException, SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tabelaMovi.getModel();
        modelo.setNumRows(0);
        MovimentacoesDAO movidao = new MovimentacoesDAO();
            
        movidao.readMoviByIdUSer(id_usuario).stream().forEach((m) -> {
            modelo.addRow(new Object[]{
                m.getTitulo(),
                m.getValor(),
                m.getData(),
                m.getCode(),
                m.getTipo()
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

        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaDespesas = new javax.swing.JTable();
        comboMounts = new javax.swing.JComboBox<>();
        comboYears = new javax.swing.JComboBox<>();
        ButtonFiltro = new javax.swing.JButton();
        filtroDespesas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaReceitas = new javax.swing.JTable();
        comboYearsReceita = new javax.swing.JComboBox<>();
        comboMountsReceita = new javax.swing.JComboBox<>();
        ButtonFiltro1 = new javax.swing.JButton();
        FiltroReceitas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TabelaCategoriaDespesa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TabelaCategoriaReceita = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaMovi = new javax.swing.JTable();
        jComboBox3 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuCadastroDespesas = new javax.swing.JMenuItem();
        jMenuCadastroReceita = new javax.swing.JMenuItem();
        jMenuCadastroCategoria = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        PerfilMenu = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuEditarUsuario = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TabelaDespesas.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelaDespesas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaDespesasKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(TabelaDespesas);

        comboMounts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - Todos", "1 - Janeiro", "2 - Fevereiro", "3 - Março", "4 - Abril", "5 - Maio", "6 - Junho", "7 - Julho", "8 - Agosto", "9 - Setembro", "10 - Outubro", "11 - Novembro", "12 - Dezembro." }));
        comboMounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMountsActionPerformed(evt);
            }
        });

        comboYears.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "2020", "2021", "2022", "2023", "2024" }));
        comboYears.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYearsActionPerformed(evt);
            }
        });

        ButtonFiltro.setText("Filtrar");
        ButtonFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFiltroActionPerformed(evt);
            }
        });

        filtroDespesas.setText("Limpar");
        filtroDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroDespesasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("FILTRO");

        jLabel3.setText("Mês");

        jLabel4.setText("Ano");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filtroDespesas)
                            .addComponent(ButtonFiltro)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboYears, 0, 119, Short.MAX_VALUE)
                            .addComponent(comboMounts, javax.swing.GroupLayout.Alignment.TRAILING, 0, 119, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(comboMounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(comboYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(filtroDespesas)
                .addGap(18, 18, 18)
                .addComponent(ButtonFiltro)
                .addGap(112, 112, 112))
        );

        jTabbedPane3.addTab("Despesas", jPanel1);

        TabelaReceitas.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelaReceitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaReceitasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaReceitas);

        comboYearsReceita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "2020", "2021", "2022", "2023", "2024" }));

        comboMountsReceita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - Todos", "1 - Janeiro", "2 - Fevereiro", "3 - Março", "4 - Abril", "5 - Maio", "6 - Junho", "7 - Julho", "8 - Agosto", "9 - Setembro", "10 - Outubro", "11 - Novembro", "12 - Dezembro." }));
        comboMountsReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMountsReceitaActionPerformed(evt);
            }
        });

        ButtonFiltro1.setText("Filtrar");
        ButtonFiltro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFiltro1ActionPerformed(evt);
            }
        });

        FiltroReceitas.setText("Limpar");
        FiltroReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltroReceitasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("FILTRO");

        jLabel5.setText("Mês");

        jLabel6.setText("Ano");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboYearsReceita, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboMountsReceita, javax.swing.GroupLayout.Alignment.TRAILING, 0, 121, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel6)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FiltroReceitas)
                            .addComponent(ButtonFiltro1)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMountsReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(3, 3, 3)
                        .addComponent(comboYearsReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(FiltroReceitas)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonFiltro1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 98, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Receitas", jPanel2);

        TabelaCategoriaDespesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descrição", "Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TabelaCategoriaDespesa);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 137, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Categorias de Despesa", jPanel4);

        TabelaCategoriaReceita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descrição", "Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(TabelaCategoriaReceita);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 137, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Categoria de Receita", jPanel3);

        tabelaMovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Valor", "Data", "Code", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tabelaMovi);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Janeiro", "2 - Fevereiro", "3 - Março", "4 - Abril", "5 - Maio", "6 - Junho", "7 - Julho", "8 - Agosto", "9 - Setembro", "10 - Outubro", "11 - Novembro", "12 - Dezembro." }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox3, 0, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 98, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Movimentações Gerais", jPanel5);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/page.png"))); // NOI18N
        jMenu1.setText("Gerenciar");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuCadastroDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/page_add.png"))); // NOI18N
        jMenuCadastroDespesas.setText("Despesa");
        jMenuCadastroDespesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuCadastroDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroDespesasActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroDespesas);

        jMenuCadastroReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/money_add.png"))); // NOI18N
        jMenuCadastroReceita.setText("Receita");
        jMenuCadastroReceita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuCadastroReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroReceitaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroReceita);

        jMenuCadastroCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/note_edit.png"))); // NOI18N
        jMenuCadastroCategoria.setText("Categoria Despesa");
        jMenuCadastroCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuCadastroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroCategoria);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/note_edit.png"))); // NOI18N
        jMenuItem5.setText("Categoria Receita");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        PerfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/user.png"))); // NOI18N
        PerfilMenu.setText("Perfil");
        PerfilMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/eye.png"))); // NOI18N
        jMenuItem6.setText("Visualizar");
        jMenuItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        PerfilMenu.add(jMenuItem6);

        jMenuEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/user_edit.png"))); // NOI18N
        jMenuEditarUsuario.setText("Editar Dados");
        jMenuEditarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarUsuarioActionPerformed(evt);
            }
        });
        PerfilMenu.add(jMenuEditarUsuario);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/user_edit.png"))); // NOI18N
        jMenuItem4.setText("Alterar Senha");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        PerfilMenu.add(jMenuItem4);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/user_delete.png"))); // NOI18N
        jMenuItem3.setText("Excluir Dados");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        PerfilMenu.add(jMenuItem3);

        jMenuBar1.add(PerfilMenu);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/computer.png"))); // NOI18N
        jMenu2.setText("Sistema");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/information.png"))); // NOI18N
        jMenuItem2.setText("Sobre");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Icones/door_out.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(27, 27, 27)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadastroDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroDespesasActionPerformed
          try {
              this.dispose();
              new TelaDespesaCRUD(id_usuario).setVisible(true);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jMenuCadastroDespesasActionPerformed

    private void jMenuCadastroReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroReceitaActionPerformed
          try {
              this.dispose();
              new TelaReceitaCRUD(id_usuario).setVisible(true);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jMenuCadastroReceitaActionPerformed

    private void jMenuEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarUsuarioActionPerformed
     new TelaEditarUsuario(id_usuario).setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jMenuEditarUsuarioActionPerformed

    private void jMenuCadastroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroCategoriaActionPerformed
          try {
              this.dispose();
              new TelaCategoriaDespesaCRUD(id_usuario).setVisible(true);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jMenuCadastroCategoriaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                this.dispose(); 
                new TelaLoginUsuario().setVisible(true);                
            }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
      new TelaVisualizarUsuario(id_usuario).setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void TabelaDespesasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaDespesasKeyReleased

       
    }//GEN-LAST:event_TabelaDespesasKeyReleased

    private void TabelaReceitasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaReceitasKeyReleased

    }//GEN-LAST:event_TabelaReceitasKeyReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new TelaSobre().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void comboMountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMountsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMountsActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new TelaEditarSenha(id_usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
          try {
              new TelaCategoriaReceitaCRUD(id_usuario).setVisible(true);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
         this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
     this.dispose();
     new TelaApagarDadosUsuario(id_usuario).setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void comboYearsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYearsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboYearsActionPerformed

    private void ButtonFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFiltroActionPerformed
    
    String mesSelecionado = comboMounts.getSelectedItem().toString();
    String anoSelecionado = comboYears.getSelectedItem().toString();
    
    String mes = mesSelecionado.split(" - ")[0];
    
    try {
        filterJtableDespesa(anoSelecionado, mes);
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_ButtonFiltroActionPerformed

    private void comboMountsReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMountsReceitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMountsReceitaActionPerformed

    private void filtroDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroDespesasActionPerformed
          try {
              readJtableDespesa();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_filtroDespesasActionPerformed

    private void ButtonFiltro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFiltro1ActionPerformed
        try {
              readJtableReceita();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_ButtonFiltro1ActionPerformed

    private void FiltroReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltroReceitasActionPerformed
       
    String mesSelecionado = comboMountsReceita.getSelectedItem().toString();
    String anoSelecionado = comboYearsReceita.getSelectedItem().toString();
    
    String mes = mesSelecionado.split(" - ")[0];
    
    try {
        filterJtableReceita(anoSelecionado, mes);
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_FiltroReceitasActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaMenuPrincipal().setVisible(true);
        });
    }
            
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonFiltro;
    private javax.swing.JButton ButtonFiltro1;
    private javax.swing.JButton FiltroReceitas;
    private javax.swing.JMenu PerfilMenu;
    private javax.swing.JTable TabelaCategoriaDespesa;
    private javax.swing.JTable TabelaCategoriaReceita;
    private javax.swing.JTable TabelaDespesas;
    private javax.swing.JTable TabelaReceitas;
    private javax.swing.JComboBox<String> comboMounts;
    private javax.swing.JComboBox<String> comboMountsReceita;
    private javax.swing.JComboBox<String> comboYears;
    private javax.swing.JComboBox<String> comboYearsReceita;
    private javax.swing.JButton filtroDespesas;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadastroCategoria;
    private javax.swing.JMenuItem jMenuCadastroDespesas;
    private javax.swing.JMenuItem jMenuCadastroReceita;
    private javax.swing.JMenuItem jMenuEditarUsuario;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelaMovi;
    // End of variables declaration//GEN-END:variables
}

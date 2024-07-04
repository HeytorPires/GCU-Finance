package Database.ConnectBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseInitializer  {

    // Configurações do banco de dados
    private static final String DB_URL = "jdbc:mysql://localhost:3306/finance?serverTimezone=America/Sao_Paulo";
    private static final String DB_NAME = "finance";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void initializeDatabase() {
    Connection connection = null;
        Statement statement = null;

        try {
            // Conecta ao servidor MySQL sem especificar o banco de dados
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();

            // Verifica se o banco de dados existe
            String checkDBExistsQuery = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + DB_NAME + "'";
            ResultSet resultSet = statement.executeQuery(checkDBExistsQuery);

            if (!resultSet.next()) {
                String createDatabaseQuery = "create database if not exists " + DB_NAME;
                statement.executeUpdate(createDatabaseQuery);
                System.out.println("Banco de dados criado: " + DB_NAME);
            } else {
                System.out.println("Banco de dados já existe: " + DB_NAME);
            }

            // Usa o banco de dados que acabou de criar
            connection.setCatalog(DB_NAME);

//           
//            String createTablesQuery = """
//               				   CREATE TABLE usuario (
//                                                       id_usuario INT AUTO_INCREMENT PRIMARY KEY,
//                                                       username VARCHAR(100) NOT NULL,
//                                                       email VARCHAR(100) NOT NULL,
//                                                       senha VARCHAR(100) NOT NULL
//                                                   );
//                                                   
//                                                   CREATE TABLE categoria_receita (
//                                                       id_categoria_receita INT AUTO_INCREMENT PRIMARY KEY,
//                                                       nome VARCHAR(80) NOT NULL,
//                                                       descricao VARCHAR(250),
//                                                       code INT NOT NULL UNIQUE,
//                                                       id_usuario INT,
//                                                       FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
//                                                   );
//                                                   
//                                                   CREATE TABLE categoria_despesa(
//                                                       id_categoria_despesa INT AUTO_INCREMENT PRIMARY KEY,
//                                                       nome VARCHAR(80) NOT NULL,
//                                                       descricao VARCHAR(250),
//                                                       code INT NOT NULL UNIQUE,
//                                                       id_usuario INT,
//                                                       FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
//                                                   );
//                                                   
//                                                   CREATE TABLE despesa (
//                                                       id_despesa INT AUTO_INCREMENT PRIMARY KEY,
//                                                       titulo VARCHAR(80) NOT NULL,
//                                                       valor DOUBLE NOT NULL,
//                                                       data DATE NOT NULL,
//                                                       code INT NOT NULL,
//                                                       id_usuario INT NOT NULL,
//                                                       FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
//                                                       FOREIGN KEY (code) REFERENCES categoria_despesa(code)
//                                                   );
//                                                   
//                                                   CREATE TABLE receita (
//                                                       id_receita INT AUTO_INCREMENT PRIMARY KEY,
//                                                       titulo VARCHAR(80) NOT NULL,
//                                                       valor DOUBLE NOT NULL,
//                                                       data DATE NOT NULL,
//                                                       code INT NOT NULL,
//                                                       id_usuario INT NOT NULL,
//                                                       FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
//                                                       FOREIGN KEY (code) REFERENCES categoria_receita(code)
//                                                   );
//                                                   
//                                                   -- Inserindo usuários
//                                                   INSERT INTO usuario (username, email, senha) VALUES 
//                                                   ('usuario1', 'usuario1@example.com', 'senha1'),
//                                                   ('usuario2', 'usuario2@example.com', 'senha2'),
//                                                   ('usuario3', 'usuario3@example.com', 'senha3');
//                                                   ('usuario3', 'admin', 'admin');
//                                                                          
//                                                   
//                                                   -- Inserindo categorias de receita para cada usuário
//                                                   INSERT INTO categoria_receita (nome, descricao, code, id_usuario) VALUES
//                                                   ('Salário', 'Salário mensal', 1001, 1),
//                                                   ('Investimento', 'Retorno de investimentos', 1002, 1),
//                                                   ('Bônus', 'Bônus anual', 1003, 1),
//                                                   ('Freelance', 'Trabalhos freelance', 1004, 1),
//                                                   ('Outros', 'Outras receitas', 1005, 1),
//                                                   
//                                                   ('Salário', 'Salário mensal', 2001, 2),
//                                                   ('Investimento', 'Retorno de investimentos', 2002, 2),
//                                                   ('Bônus', 'Bônus anual', 2003, 2),
//                                                   ('Freelance', 'Trabalhos freelance', 2004, 2),
//                                                   ('Outros', 'Outras receitas', 2005, 2),
//                                                   
//                                                   ('Salário', 'Salário mensal', 3001, 3),
//                                                   ('Investimento', 'Retorno de investimentos', 3002, 3),
//                                                   ('Bônus', 'Bônus anual', 3003, 3),
//                                                   ('Freelance', 'Trabalhos freelance', 3004, 3),
//                                                   ('Outros', 'Outras receitas', 3005, 3);
//                                                   
//                                                   -- Inserindo categorias de despesa para cada usuário
//                                                   INSERT INTO categoria_despesa (nome, descricao, code, id_usuario) VALUES
//                                                   ('Alimentação', 'Despesas com alimentação', 4001, 1),
//                                                   ('Transporte', 'Despesas com transporte', 4002, 1),
//                                                   ('Moradia', 'Despesas com moradia', 4003, 1),
//                                                   ('Lazer', 'Despesas com lazer', 4004, 1),
//                                                   ('Outros', 'Outras despesas', 4005, 1),
//                                                   
//                                                   ('Alimentação', 'Despesas com alimentação', 5001, 2),
//                                                   ('Transporte', 'Despesas com transporte', 5002, 2),
//                                                   ('Moradia', 'Despesas com moradia', 5003, 2),
//                                                   ('Lazer', 'Despesas com lazer', 5004, 2),
//                                                   ('Outros', 'Outras despesas', 5005, 2),
//                                                   
//                                                   ('Alimentação', 'Despesas com alimentação', 6001, 3),
//                                                   ('Transporte', 'Despesas com transporte', 6002, 3),
//                                                   ('Moradia', 'Despesas com moradia', 6003, 3),
//                                                   ('Lazer', 'Despesas com lazer', 6004, 3),
//                                                   ('Outros', 'Outras despesas', 6005, 3);
//                                                   
//                                                   -- Inserindo receitas para cada usuário
//                                                   INSERT INTO receita (titulo, valor, data, code, id_usuario) VALUES
//                                                   ('Salário de Junho', 5000, '2024-06-01', 1001, 1),
//                                                   ('Dividendo de ações', 300, '2024-06-05', 1002, 1),
//                                                   ('Bônus trimestral', 1000, '2024-06-10', 1003, 1),
//                                                   ('Projeto freelance', 1500, '2024-06-15', 1004, 1),
//                                                   ('Venda de itens', 200, '2024-06-20', 1005, 1),
//                                                   
//                                                   ('Salário de Junho', 5500, '2024-06-01', 2001, 2),
//                                                   ('Dividendo de ações', 350, '2024-06-05', 2002, 2),
//                                                   ('Bônus trimestral', 1200, '2024-06-10', 2003, 2),
//                                                   ('Projeto freelance', 1300, '2024-06-15', 2004, 2),
//                                                   ('Venda de itens', 250, '2024-06-20', 2005, 2),
//                                                   
//                                                   ('Salário de Junho', 6000, '2024-06-01', 3001, 3),
//                                                   ('Dividendo de ações', 400, '2024-06-05', 3002, 3),
//                                                   ('Bônus trimestral', 1500, '2024-06-10', 3003, 3),
//                                                   ('Projeto freelance', 1700, '2024-06-15', 3004, 3),
//                                                   ('Venda de itens', 300, '2024-06-20', 3005, 3);
//                                                   
//                                                   -- Inserindo despesas para cada usuário
//                                                   INSERT INTO despesa (titulo, valor, data, code, id_usuario) VALUES
//                                                   ('Compras de supermercado', 200, '2024-06-02', 4001, 1),
//                                                   ('Bilhete de transporte', 50, '2024-06-04', 4002, 1),
//                                                   ('Aluguel', 1000, '2024-06-08', 4003, 1),
//                                                   ('Cinema', 30, '2024-06-12', 4004, 1),
//                                                   ('Despesas diversas', 100, '2024-06-18', 4005, 1),
//                                                   
//                                                   ('Compras de supermercado', 220, '2024-06-02', 5001, 2),
//                                                   ('Bilhete de transporte', 55, '2024-06-04', 5002, 2),
//                                                   ('Aluguel', 1100, '2024-06-08', 5003, 2),
//                                                   ('Cinema', 35, '2024-06-12', 5004, 2),
//                                                   ('Despesas diversas', 120, '2024-06-18', 5005, 2),
//                                                   
//                                                   ('Compras de supermercado', 250, '2024-06-02', 6001, 3),
//                                                   ('Bilhete de transporte', 60, '2024-06-04', 6002, 3),
//                                                   ('Aluguel', 1200, '2024-06-08', 6003, 3),
//                                                   ('Cinema', 40, '2024-06-12', 6004, 3),
//                                                   ('Despesas diversas', 150, '2024-06-18', 6005, 3);
//                                                   
//                                                   -- View
//                                                   create view MoviGeral as 
//                                                   select r.titulo, r.valor, r.data, r.code, r.id_usuario, "Receita" as tipo 
//                                                   from receita r
//                                                    union all
//                                                   select d.titulo, d.valor, d.data, d.code, d.id_usuario,  "Despesa" as tipo 
//                                                   from despesa d;
//            """;

               // statement.executeUpdate(createTablesQuery);
           // System.out.println("Tabelas criadas e visão MoviGeral criada.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

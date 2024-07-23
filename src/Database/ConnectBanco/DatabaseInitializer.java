package Database.ConnectBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseInitializer {

    // Configurações do banco de dados
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "finance";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void initializeDatabase() {
        Connection connection = null;
        Statement statement = null;

        try {
            // Conecta ao servidor MySQL
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();

            // Verifica se o banco de dados existe
            String checkDBExistsQuery = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + DB_NAME + "'";
            ResultSet resultSet = statement.executeQuery(checkDBExistsQuery);

            if (!resultSet.next()) {
                String createDatabaseQuery = "CREATE DATABASE " + DB_NAME;
                statement.executeUpdate(createDatabaseQuery);
                System.out.println("Banco de dados criado: " + DB_NAME);
            } else {
                System.out.println("Banco de dados já existe: " + DB_NAME);
            }

            // Usa o banco de dados
            connection = DriverManager.getConnection(DB_URL + DB_NAME, USER, PASSWORD);
            statement = connection.createStatement();

            // Criação das tabelas
            String createTablesQuery = """
                CREATE TABLE IF NOT EXISTS usuario (
                    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(100) NOT NULL,
                    email VARCHAR(100) NOT NULL,
                    senha VARCHAR(100) NOT NULL
                );
            """;
            statement.executeUpdate(createTablesQuery);

            createTablesQuery = """
                CREATE TABLE IF NOT EXISTS categoria_receita (
                    id_categoria_receita INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(80) NOT NULL,
                    descricao VARCHAR(250),
                    code INT NOT NULL,
                    id_usuario INT,
                    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
                );
            """;
            statement.executeUpdate(createTablesQuery);

            createTablesQuery = """
                CREATE TABLE IF NOT EXISTS categoria_despesa (
                    id_categoria_despesa INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(80) NOT NULL,
                    descricao VARCHAR(250),
                    code INT NOT NULL,
                    id_usuario INT,
                    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
                );
            """;
            statement.executeUpdate(createTablesQuery);

            createTablesQuery = """
                CREATE TABLE IF NOT EXISTS despesa (
                    id_despesa INT AUTO_INCREMENT PRIMARY KEY,
                    titulo VARCHAR(80) NOT NULL,
                    valor DOUBLE NOT NULL,
                    data DATE NOT NULL,
                    id_categoria_despesa INT NOT NULL,
                    id_usuario INT NOT NULL,
                    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
                    FOREIGN KEY (id_categoria_despesa) REFERENCES categoria_despesa(id_categoria_despesa)
                );
            """;
            statement.executeUpdate(createTablesQuery);

            createTablesQuery = """
                CREATE TABLE IF NOT EXISTS receita (
                    id_receita INT AUTO_INCREMENT PRIMARY KEY,
                    titulo VARCHAR(80) NOT NULL,
                    valor DOUBLE NOT NULL,
                    data DATE NOT NULL,
                    id_categoria_receita INT NOT NULL,
                    id_usuario INT NOT NULL,
                    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
                    FOREIGN KEY (id_categoria_receita) REFERENCES categoria_receita(id_categoria_receita)
                );
            """;
            statement.executeUpdate(createTablesQuery);

            // Inserção de dados
            String insertDataQuery = """
                INSERT IGNORE INTO usuario (username, email, senha) VALUES 
                ('usuario1', 'usuario1@gmail.com', 'senha1'),
                ('usuario2', 'usuario2@gmail.com', 'senha2'),
                ('usuario3', 'usuario3@gmail.com', 'senha3');
            """;
            statement.executeUpdate(insertDataQuery);

            // Excluindo a view se ela já existir
            String dropViewQuery = "DROP VIEW IF EXISTS MoviGeral";
            statement.executeUpdate(dropViewQuery);

            // Criação da view
            String createViewQuery = """
                CREATE VIEW MoviGeral AS
                SELECT r.titulo, r.valor, r.data, r.id_usuario, 'Receita' AS tipo 
                FROM receita r
                UNION ALL
                SELECT d.titulo, d.valor, d.data, d.id_usuario, 'Despesa' AS tipo 
                FROM despesa d;
            """;
            statement.executeUpdate(createViewQuery);
            System.out.println("Visão MoviGeral criada.");

            System.out.println("Tabelas e visão MoviGeral criadas.");
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

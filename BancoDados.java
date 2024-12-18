package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class BancoDados {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void criarTabelas() {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS jogo";
        String useDatabaseSQL = "USE jogo";
        String createPerguntasSQL = 
            "CREATE TABLE IF NOT EXISTS perguntas (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "tipo VARCHAR(20) NOT NULL, " +
            "texto VARCHAR(255) NOT NULL, " +
            "respostaCorreta VARCHAR(10) NOT NULL)";
        
        String createOpcoesPerguntasSQL =
            "CREATE TABLE IF NOT EXISTS opcoes_perguntas (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "pergunta_id INT, " +
            "opcao VARCHAR(100), " +
            "FOREIGN KEY (pergunta_id) REFERENCES perguntas(id))";

        String createJogadoresSQL = 
            "CREATE TABLE IF NOT EXISTS jogadores (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "nome VARCHAR(100) NOT NULL, " +
            "sobrenome VARCHAR(100) NOT NULL, " +
            "nickname VARCHAR(50) UNIQUE NOT NULL, " +
            "pontuacao INT DEFAULT 0, " +
            "data_jogo TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            

            statement.executeUpdate(createDatabaseSQL);

            statement.executeUpdate(useDatabaseSQL);
 
            statement.executeUpdate(createPerguntasSQL);
            statement.executeUpdate(createOpcoesPerguntasSQL);
            statement.executeUpdate(createJogadoresSQL);
            
            System.out.println("Banco de dados e tabelas criados com sucesso!");
            

            inserirPerguntasEOpcoes(statement);
        } catch (SQLException e) {
            System.out.println("Erro ao criar o banco de dados ou as tabelas: " + e.getMessage());
        }
    }

    public static void inserirPerguntasEOpcoes(Statement statement) {
        try {

        	statement.executeUpdate("INSERT INTO perguntas (tipo, texto, respostaCorreta) VALUES " +
                    "('MCE', 'Qual é o maior planeta do Sistema Solar?', 'C'), " +
                    "('MCE', 'Qual é o resultado de 5 x 6?', 'B'), " +
                    "('MCE', 'Quem escreveu ''Romeu e Julieta''?', 'B'), " +
                    "('MCE', 'Qual país é conhecido como a Terra do Sol Nascente?', 'B'), " +
                    "('MCE', 'Qual é a capital da França?', 'C'), " +
                    "('VF', 'Java é uma linguagem de programação? (V/F)', 'V'), " +
                    "('VF', 'JavaScript e Java são linguagens iguais? (V/F)', 'F'), " +
                    "('VF', 'PC é uma sigla do inglês para Personal Computer? (V/F)', 'V'), " +
                    "('VF', 'A lua é um satélite natural da Terra? (V/F)', 'V'), " +
                    "('VF', 'A capital do Brasil é São Paulo? (V/F)', 'F'), " +
                    "('VF', 'O maior órgão do ser humano é a pele? (V/F)', 'V'), " +
                    "('VF', 'O Java foi lançado em 1995? (V/F)', 'V'), " +
                    "('VF', '1 + 1 é igual a 11? (V/F)', 'F'), " +
                    "('VF', 'Spotify é uma aplicação de streaming de vídeo? (V/F)', 'F')");

            

            statement.executeUpdate("INSERT INTO opcoes_perguntas (pergunta_id, opcao) VALUES " +
                    "(1, 'A. Terra'), (1, 'B. Marte'), (1, 'C. Júpiter'), (1, 'D. Saturno'), " +
                    "(2, 'A. 25'), (2, 'B. 30'), (2, 'C. 35'), (2, 'D. 40'), " +
                    "(3, 'A. Machado de Assis'), (3, 'B. William Shakespeare'), (3, 'C. Charles Dickens'), (3, 'D. J.K. Rowling'), " +
                    "(4, 'A. China'), (4, 'B. Japão'), (4, 'C. Coreia do Sul'), (4, 'D. Índia'), " +
                    "(5, 'A. Londres'), (5, 'B. Roma'), (5, 'C. Paris'), (5, 'D. Berlim')");
            
            System.out.println("Perguntas e opções inseridas com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir perguntas e opções: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        criarTabelas();
    }
}

package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo", "root", "");

            GetNomes getNomes = new GetNomes();
            Jogador jogador = null;
            
            boolean valid = false;
            while (!valid) {
                try {
                    jogador = getNomes.initNames();
                    valid = true;
                } catch (CampoInvalidoException e) {
                    System.out.println("Erro: " + e.getMessage());
                    System.out.println("Por favor, insira novamente os dados corretamente.\n");
                }
            }

            JogadorDAO jogadorDAO = new JogadorDAO(connection);
            jogadorDAO.inserirJogador(jogador);

            PerguntaDAO perguntaDAO = new PerguntaDAO(connection);
            JogoBO jogoBO = new JogoBO(perguntaDAO, jogadorDAO);
            JogoService jogoService = new JogoService(connection, jogoBO);

            jogoService.iniciarJogo(jogador);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo", "root", "");
            GetNomes getNomes = new GetNomes();
            Jogador jogador = getNomes.initNames();
            if (jogador == null) {
                System.out.println("Erro: Jogador não foi criado corretamente.");
                return;
            } else {
            	System.out.println("Adicionado");
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

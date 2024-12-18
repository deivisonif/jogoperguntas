package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo", "root", "");
            PerguntaDAO perguntaDAO = new PerguntaDAO(connection);
            JogadorDAO jogadorDAO = new JogadorDAO();
            JogoBO jogoBO = new JogoBO(perguntaDAO, jogadorDAO);
            JogoService jogoService = new JogoService(jogoBO);
            
            jogoService.iniciarJogo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

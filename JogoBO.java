package projeto;

import java.util.List;

public class JogoBO {

    private PerguntaDAO perguntaDAO;
    private JogadorDAO jogadorDAO;

    public JogoBO(PerguntaDAO perguntaDAO, JogadorDAO jogadorDAO) {
        this.perguntaDAO = perguntaDAO;
        this.jogadorDAO = jogadorDAO;
    }

    public List<Pergunta> buscarPerguntasAleatorias() throws JogoException {
        return perguntaDAO.buscarPerguntasAleatorias();
    }

    public void atualizarRanking(Jogador jogador) throws JogoException {
        jogadorDAO.atualizarRanking(jogador);
    }

    public List<Jogador> buscarRanking() throws JogoException {
        return jogadorDAO.buscarRanking();
    }
}

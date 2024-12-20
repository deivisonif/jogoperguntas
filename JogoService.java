package projeto;

import java.util.List;
import java.util.Scanner;
import java.sql.Connection;

public class JogoService {

    private Connection connection;
    private JogadorDAO jogadorDAO;
    private JogoBO jogoBO;
    public JogoService(Connection connection, JogoBO jogoBO) {
    	this.jogoBO = jogoBO;
        this.connection = connection;
        this.jogadorDAO = new JogadorDAO(connection);
    }


    public void iniciarJogo(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);
        jogador.aumentarPontuacao(jogador.getPontuacao());
        jogadorDAO.atualizarPontuacao(jogador);

        try {
            List<Pergunta> perguntas = jogoBO.buscarPerguntasAleatorias();

            for (Pergunta pergunta : perguntas) {
                System.out.println("Pergunta: " + pergunta.getTexto());
                if (pergunta instanceof PerguntaMultiplaEscolha) {
                    PerguntaMultiplaEscolha perguntaMultipla = (PerguntaMultiplaEscolha) pergunta;
                    List<String> opcoes = perguntaMultipla.getOpcoes();
                    char opcaoLetra = ' ';
                    
                    for (String opcao : opcoes) {
                        System.out.println(opcao);
                        opcaoLetra++;
                    }
                }
                System.out.print("Resposta: ");
                String resposta = scanner.nextLine();

                if (pergunta.validarResposta(resposta)) {
                    jogador.aumentarPontuacao(1);
                    System.out.println("Resposta correta! Sua pontuação atual: " + jogador.getPontuacao());
                } else {
                    System.out.println("Resposta incorreta.");
                }
                System.out.println("--------------------------------------------------------------------");
            }
            System.out.println("");

            jogoBO.atualizarRanking(jogador);
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Jogo finalizado. Sua pontuação foi: " + jogador.getPontuacao());
            System.out.println("--------------------------------------------------------------------");
            System.out.println("");
            mostrarRanking();

        } catch (JogoException e) {
            System.out.println("Erro durante o jogo: " + e.getMessage());
        }
    }

    public void mostrarRanking() {
        try {
            List<Jogador> ranking = jogoBO.buscarRanking();
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Ranking da maiores pontuações:");
            for (Jogador rank : ranking) {
                System.out.println(rank.getNome() + rank.getSobrenome() + " (" + rank.getNickname() + ") - Pontuação: " + rank.getPontuacao());
            }

            System.out.println("--------------------------------------------------------------------");
        } catch (JogoException e) {
            System.out.println("Erro ao exibir o ranking: " + e.getMessage());
        }
    }
}

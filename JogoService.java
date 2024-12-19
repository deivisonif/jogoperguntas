package projeto;

import java.util.List;
import java.util.Scanner;

public class JogoService {

    private JogoBO jogoBO;
    private Jogador jogador;

    public JogoService(JogoBO jogoBO) {
        this.jogoBO = jogoBO;
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("                         Bem-vindo ao Quiz!                         ");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Escolha um nickname: ");
        String nickname = scanner.nextLine();
        System.out.println("--------------------------------------------------------------------");

        jogador = new Jogador(nome, sobrenome, nickname);

        boolean continuarJogando = true;
        while (continuarJogando) {
            System.out.println("O jogo vai começar!");
            System.out.println("--------------------------------------------------------------------");

            try {
                List<Pergunta> perguntas = jogoBO.buscarPerguntasAleatorias();

                for (Pergunta pergunta : perguntas) {
                    System.out.println("Pergunta: " + pergunta.getTexto());
                    if (pergunta instanceof PerguntaMultiplaEscolha) {
                        PerguntaMultiplaEscolha perguntaMultipla = (PerguntaMultiplaEscolha) pergunta;
                        List<String> opcoes = perguntaMultipla.getOpcoes();
                        char opcaoLetra = 'A';

                        for (String opcao : opcoes) {
                            System.out.println(opcaoLetra + ") " + opcao);
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

                // Pergunta ao usuário se deseja jogar novamente
                System.out.print("Deseja jogar novamente? (S/N): ");
                String resposta = scanner.next().toUpperCase();
                scanner.nextLine(); // Limpar a quebra de linha

                if (!resposta.equals("S")) {
                    continuarJogando = false;
                    System.out.println("Obrigado por jogar! Até a próxima.");
                }
            } catch (JogoException e) {
                System.out.println("Erro durante o jogo: " + e.getMessage());
            }
        }
    }

    public void mostrarRanking() {
        try {
            List<Jogador> ranking = jogoBO.buscarRanking();
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Ranking das maiores pontuações:");
            for (Jogador rank : ranking) {
                System.out.println(rank.getNome() + " " + rank.getSobrenome() + " (" + rank.getNickname() + ") - Pontuação: " + rank.getPontuacao());
            }
            System.out.println("--------------------------------------------------------------------");
        } catch (JogoException e) {
            System.out.println("Erro ao exibir o ranking: " + e.getMessage());
        }
    }
}

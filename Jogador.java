package projeto;

public class Jogador {
    private String nome;
    private String sobrenome;
    private String nickname;
    private int pontuacao;

    public Jogador(String nome, String sobrenome, String nickname) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nickname = nickname;
        this.pontuacao = 0;
    }

    public void incrementarPontuacao() {
        this.pontuacao++;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome + " (" + nickname + ")";
    }
}

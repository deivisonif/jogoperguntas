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

    public void aumentarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }
}

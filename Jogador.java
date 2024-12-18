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

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNickname() {
        return nickname;
    }

    public int getPontuacao() {
        return pontuacao;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}

package projeto;

public abstract class Pergunta {
    private final int id;
    private final String texto;
    private final String respostaCorreta;

    public Pergunta(int id, String texto, String respostaCorreta) {
        this.id = id;
        this.texto = texto;
        this.respostaCorreta = respostaCorreta;
    }

    public abstract boolean validarResposta(String resposta);

    public int getId() { return id; }
    public String getTexto() { return texto; }
    public String getRespostaCorreta() { return respostaCorreta; }
}

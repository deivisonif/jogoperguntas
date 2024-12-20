package projeto;

import java.util.List;

public class PerguntaMultiplaEscolha extends Pergunta {
    private List<String> opcoes;

    public PerguntaMultiplaEscolha(int id, String texto, List<String> opcoes, String respostaCorreta) {
        super(id, texto, respostaCorreta);
        this.opcoes = opcoes;
    }

    @Override
    public boolean validarResposta(String resposta) {
        return resposta.equalsIgnoreCase(getRespostaCorreta());
    }

    public List<String> getOpcoes() {
        return opcoes;
    }
}

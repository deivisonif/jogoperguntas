package projeto;

import java.util.List;

public class PerguntaMultiplaEscolha extends Pergunta {
    private List<String> opcoes;

    public PerguntaMultiplaEscolha(int id, String texto, List<String> opcoes, String respostaCorreta) {
        super(id, texto, respostaCorreta);
        // Validação para garantir que as opções incluem a resposta correta
        if (!opcoes.contains(respostaCorreta)) {
            throw new IllegalArgumentException("As opções devem incluir a resposta correta.");
        }
        this.opcoes = opcoes;
    }

    @Override
    public boolean validarResposta(String resposta) {
        return opcoes.contains(resposta.toUpperCase()) && resposta.equalsIgnoreCase(getRespostaCorreta());
    }

    public List<String> getOpcoes() {
        return opcoes;
    }
}

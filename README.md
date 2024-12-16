# jogoperguntas

package projeto;

public class PerguntaVF extends Pergunta {

 public PerguntaVF(int id, String texto, String respostaCorreta) {
     super(id, texto, respostaCorreta);
 }

 @Override
 public boolean validarResposta(String resposta) {
     return resposta.equalsIgnoreCase(getRespostaCorreta());
 }
}

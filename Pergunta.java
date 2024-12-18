package projeto;

import java.util.List;

public abstract class Pergunta implements ValidadorResposta {
 private int id;
 private String texto;
 private String respostaCorreta;

 public Pergunta(int id, String texto, String respostaCorreta) {
     this.id = id;
     this.texto = texto;
     this.respostaCorreta = respostaCorreta;
 }

 public int getId() {
     return id;
 }

 public String getTexto() {
     return texto;
 }

 public String getRespostaCorreta() {
     return respostaCorreta;
 }

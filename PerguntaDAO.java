package projeto;

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class PerguntaDAO {

    private Connection connection;

    public PerguntaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Pergunta> buscarPerguntasAleatorias() throws JogoException, PerguntaNaoEncontradaException {
        List<Pergunta> perguntas = new ArrayList<>();
        String query = "SELECT * FROM perguntas ORDER BY RAND() LIMIT 10";
        
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String texto = rs.getString("texto");
                String tipo = rs.getString("tipo");
                String respostaCorreta = rs.getString("respostaCorreta");

                if (tipo.equals("VF")) {
                    
                    perguntas.add(new PerguntaVF(id, texto, respostaCorreta));
                } else if (tipo.equals("MCE")) {
                    
                    List<String> listaOpcoes = new ArrayList<>();
                    String opcoesQuery = "SELECT opcao FROM opcoes_perguntas WHERE pergunta_id = ?";
                    try (PreparedStatement opcoesStmt = connection.prepareStatement(opcoesQuery)) {
                        opcoesStmt.setInt(1, id);
                        try (ResultSet opcoesRs = opcoesStmt.executeQuery()) {
                            while (opcoesRs.next()) {
                                listaOpcoes.add(opcoesRs.getString("opcao"));
                            }
                        }
                    } catch (SQLException e) {
                        throw new JogoException("Erro ao buscar opções para a pergunta de múltipla escolha: " + e.getMessage());
                    }
                    perguntas.add(new PerguntaMultiplaEscolha(id, texto, listaOpcoes, respostaCorreta));
                }
            }
        } catch (SQLException e) {
            throw new JogoException("Erro ao buscar perguntas: " + e.getMessage());
        }
        
        
        if (perguntas.isEmpty()) {
            throw new PerguntaNaoEncontradaException("Nenhuma pergunta foi encontrada no banco de dados.");
        }
        
        return perguntas;
    }
}

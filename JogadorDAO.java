package projeto;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class JogadorDAO {

    private Connection connection;

    public JogadorDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirJogador(Jogador jogador) {
        String sql = "INSERT INTO jogadores (nome, sobrenome, nickname, pontuacao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jogador.getNome());
            stmt.setString(2, jogador.getSobrenome());
            stmt.setString(3, jogador.getNickname());
            stmt.setInt(4, jogador.getPontuacao());
            stmt.executeUpdate();
            System.out.println("Nome: " + jogador.getNome() + jogador.getSobrenome() + jogador.getNickname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPontuacao(Jogador jogador) {
        String sql = "UPDATE jogadores SET pontuacao = ? WHERE nickname = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, jogador.getPontuacao());
            stmt.setString(2, jogador.getNickname());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Jogador buscarJogadorPorNickname(String nickname) {
        String sql = "SELECT * FROM jogadores WHERE nickname = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nickname);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Jogador(
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("nickname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Jogador> getTop3Jogadores() {
        List<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM jogadores ORDER BY pontuacao DESC, data_jogo DESC LIMIT 3";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                jogadores.add(new Jogador(
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("nickname")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogadores;
    }

    public void atualizarRanking(Jogador jogador) throws JogoException {
        String query = "UPDATE jogadores SET pontuacao = ? WHERE nickname = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, jogador.getPontuacao());
            stmt.setString(2, jogador.getNickname());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new JogoException("Erro ao atualizar ranking: " + e.getMessage());
        }
    }

    public List<Jogador> buscarRanking() throws JogoException {
        List<Jogador> ranking = new ArrayList<>();
        String query = "SELECT nome, sobrenome, nickname, pontuacao FROM jogadores ORDER BY pontuacao DESC LIMIT 3";
        
        try (Statement stmt = connection.createStatement(); ResultSet result = stmt.executeQuery(query)) {
            while (result.next()) {
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                String nickname = result.getString("nickname");
                int pontuacao = result.getInt("pontuacao");

                Jogador jogador = new Jogador(nome, sobrenome, nickname);
                jogador.setPontuacao(pontuacao);
                ranking.add(jogador);
            }
        } catch (SQLException e) {
            throw new JogoException("Erro ao buscar ranking: " + e.getMessage());
        }
        
        return ranking;
    }
}

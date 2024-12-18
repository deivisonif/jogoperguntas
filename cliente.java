package projeto;

import java.io.*;
import java.net.*;

public class Cliente {
    private static final String Host = "localhost";
    private static final int Porta = 55685;

    public static void main(String[] args) {
        try (Socket socket = new Socket(Host, Porta);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader tecladoCliente = new BufferedReader(new InputStreamReader(System.in))) {

            String mensagem;
            String nomeCliente = "";

            mensagem = entrada.readLine();
            System.out.println(mensagem);

            mensagem = entrada.readLine();
            System.out.print(mensagem);
            nomeCliente = tecladoCliente.readLine();
            saida.println(nomeCliente);
            
            mensagem = entrada.readLine();
            System.out.println(mensagem);
            System.out.println("");

            String resposta;
            while ((mensagem = entrada.readLine()) != null) {
                if (mensagem.contains("(V/F)")) {
                    System.out.println("Pergunta: " + mensagem);
                    System.out.print("Resposta: ");
                    resposta = tecladoCliente.readLine();
                    saida.println(resposta);
                }
                
               if (mensagem.contains("Resposta correta!") || mensagem.contains("Resposta incorreta.")) {
                    System.out.println(mensagem);
                    System.out.println("");
               }
                if (mensagem.contains("Fim do jogo")) {
                    System.out.println(mensagem);
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }
}

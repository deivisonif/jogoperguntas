package projeto;

import java.util.Scanner;

public class GetNomes {
    
	public Jogador initNames() throws CampoInvalidoException {
		Scanner scanner = new Scanner(System.in);
        
        System.out.println("--------------------------------------------------------------------");
        System.out.println("                         Bem-vindo ao Quiz!                         ");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine().trim();
        System.out.print("Escolha um nickname: ");
        String nickname = scanner.nextLine().trim();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("O jogo vai começar!");
        System.out.println("--------------------------------------------------------------------");

        if (nome.isEmpty() || sobrenome.isEmpty() || nickname.isEmpty()) {
            throw new CampoInvalidoException("Nome, sobrenome, nickname ou ambos estão vazios!");
        }
        
        return new Jogador(nome, sobrenome, nickname);
	}
}

Descrição do Projeto
Este projeto é um jogo de perguntas e respostas desenvolvido como parte da disciplina Programação Orientada a Objetos no curso de Sistemas de Informação pelo Instituto Federal de Alagoas (IFAL). O objetivo do jogo é oferecer uma experiência interativa onde os usuários podem testar seus conhecimentos em diversos temas, com uma interface simples e intuitiva, promovendo a aplicação prática dos conceitos de POO.

Funcionalidades:
Cadastro de Perguntas e Respostas: Permite que o administrador insira novas perguntas com múltiplas alternativas e a indicação da resposta correta;
Sistema de Pontuação: Acumula pontos para o jogador a cada resposta correta;
Feedback Imediato: Indica se a resposta foi correta ou incorreta após a escolha do jogador;
Interface Interativa: Navegação simples e visual amigável para o usuário;
Categorias de Perguntas: Suporte a múltiplos tópicos para uma experiência diversificada;
Persistência de Dados: Salva o progresso ou os dados das perguntas.

Tecnologias Utilizadas
Linguagem de Programação: Java;
Paradigma: Programação Orientada a Objetos;
Ambiente de Desenvolvimento: Eclipse;

Estrutura do Projeto:

Diretório src/projeto
Contém todas as classes principais do sistema. Abaixo está uma explicação sobre cada uma:

* BancoDados.java: Classe responsável por simular um banco de dados em memória, armazenando perguntas, jogadores ou qualquer outra informação persistente usada durante o jogo;
* GetNomes.java: Provavelmente uma classe utilitária para gerar ou manipular nomes de jogadores ou elementos do jogo;
* Jogador.java: Classe que encapsula os dados e comportamento de um jogador, como nome, pontuação e histórico;
* JogadorDAO.java: Classe de acesso a dados (Data Access Object) para realizar operações de leitura, escrita, atualização ou exclusão relacionadas ao jogador;
* JogadorInvalidoException.java: Classe que define uma exceção personalizada para tratar casos de jogadores inválidos ou erros relacionados;
* JogoBO.java: Representa as regras de negócio do jogo (BO - Business Object). Contém a lógica principal das operações que regem o funcionamento do jogo;
* JogoException.java: Define uma exceção personalizada para erros gerais relacionados ao jogo;
* JogoService.java: Classe que atua como intermediária entre a interface do usuário e as classes de negócio. Gerencia as interações e a execução das regras do jogo;
* Main.java: Classe principal responsável por inicializar e executar o jogo. Contém o método main, que é o ponto de entrada do programa;
* Pergunta.java: Representa uma pergunta no jogo, incluindo atributos como enunciado, alternativas e a resposta correta;
* PerguntaDAO.java: Classe de acesso a dados para manipular as informações relacionadas às perguntas (ex.: salvar, buscar ou atualizar);
* PerguntaMultiplaEscolha.java: Subclasse de Pergunta que adiciona funcionalidades específicas para perguntas de múltipla escolha;
* PerguntaNaoEncontradaException.java: Classe para tratar exceções relacionadas a perguntas não encontradas no banco de dados ou memória;
* PerguntaVF.java: Subclasse de Pergunta que implementa funcionalidades específicas para perguntas de verdadeiro ou falso;
* ValidadorResposta.java: Classe utilitária responsável por validar as respostas dos jogadores, verificando se estão corretas.


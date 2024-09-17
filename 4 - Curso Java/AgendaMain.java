import java.util.Scanner;

// Classe Contato com os atributos nome e telefone
class exercicio06 {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
}

// Exceção personalizada para quando o contato não for encontrado
class ContatoNaoEncontradoException extends Exception {
    public ContatoNaoEncontradoException(String message) {
        super(message);
    }
}

// Exceção personalizada para quando a agenda estiver cheia
class AgendaCheiaException extends Exception {
    public AgendaCheiaException(String message) {
        super(message);
    }
}

// Classe Agenda com funcionalidades de adicionar, remover, buscar e listar contatos
class AgendaTelefonica {
    private Contato[] contatos;
    private int totalContatos;

    public AgendaTelefonica() {
        this.contatos = new Contato[100];  // Limite de 100 contatos
        this.totalContatos = 0;
    }

    // Adicionar contato
    public void adicionarContato(String nome, String telefone) throws AgendaCheiaException {
        if (totalContatos >= 100) {
            throw new AgendaCheiaException("A agenda está cheia. Não é possível adicionar mais contatos.");
        }
        contatos[totalContatos++] = new Contato(nome, telefone);
        System.out.println("Contato adicionado com sucesso!");
    }

    // Remover contato pelo nome
    public void removerContato(String nome) throws ContatoNaoEncontradoException {
        for (int i = 0; i < totalContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                // Remover o contato deslocando os outros à esquerda
                for (int j = i; j < totalContatos - 1; j++) {
                    contatos[j] = contatos[j + 1];
                }
                contatos[--totalContatos] = null;  // Remove o último contato após deslocamento
                System.out.println("Contato removido com sucesso!");
                return;
            }
        }
        throw new ContatoNaoEncontradoException("Contato com o nome '" + nome + "' não foi encontrado.");
    }

    // Buscar contato pelo nome
    public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
        for (int i = 0; i < totalContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontradoException("Contato com o nome '" + nome + "' não foi encontrado.");
    }

    // Listar todos os contatos
    public void listarContatos() {
        if (totalContatos == 0) {
            System.out.println("A agenda está vazia.");
        } else {
            for (int i = 0; i < totalContatos; i++) {
                System.out.println(contatos[i]);
            }
        }
    }
}

public class AgendaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaTelefonica agenda = new AgendaTelefonica();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            switch (opcao) {
                case 1:
                    // Adicionar Contato
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    try {
                        agenda.adicionarContato(nome, telefone);
                    } catch (AgendaCheiaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    // Remover Contato
                    System.out.print("Digite o nome do contato a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    try {
                        agenda.removerContato(nomeRemover);
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    // Buscar Contato
                    System.out.print("Digite o nome do contato a ser buscado: ");
                    String nomeBuscar = scanner.nextLine();
                    try {
                        Contato contato = agenda.buscarContato(nomeBuscar);
                        System.out.println("Contato encontrado: " + contato);
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    // Listar Contatos
                    agenda.listarContatos();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}

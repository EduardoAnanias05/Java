import java.util.ArrayList;
import java.util.Scanner;

public class exercicio02 {
    static class Funcionario {
        String nome;
        int idade;
        double salario;

        Funcionario(String nome, int idade, double salario) {
            this.nome = nome;
            this.idade = idade;
            this.salario = salario;
        }
    }

    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Remover funcionário");
            System.out.println("3. Listar funcionários");
            System.out.println("4. Calcular média salarial");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarFuncionario(funcionarios, scanner);
                    break;
                case 2:
                    removerFuncionario(funcionarios, scanner);
                    break;
                case 3:
                    listarFuncionarios(funcionarios);
                    break;
                case 4:
                    calcularMediaSalarial(funcionarios);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    public static void adicionarFuncionario(ArrayList<Funcionario> funcionarios, Scanner scanner) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        System.out.print("Digite o salário: ");
        double salario = scanner.nextDouble();

        funcionarios.add(new Funcionario(nome, idade, salario));
        System.out.println("Funcionário adicionado!");
    }

    public static void removerFuncionario(ArrayList<Funcionario> funcionarios, Scanner scanner) {
        System.out.print("Digite o nome do funcionário a ser removido: ");
        String nome = scanner.nextLine();
        boolean encontrado = false;

        for (Funcionario f : funcionarios) {
            if (f.nome.equalsIgnoreCase(nome)) {
                funcionarios.remove(f);
                System.out.println("Funcionário removido!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void listarFuncionarios(ArrayList<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : funcionarios) {
                System.out.println("Nome: " + f.nome + ", Idade: " + f.idade + ", Salário: " + f.salario);
            }
        }
    }

    public static void calcularMediaSalarial(ArrayList<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        double somaSalarios = 0;
        for (Funcionario f : funcionarios) {
            somaSalarios += f.salario;
        }

        double media = somaSalarios / funcionarios.size();
        System.out.printf("Média salarial: %.2f\n", media);
    }
}

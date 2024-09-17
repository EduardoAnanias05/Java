import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Operacao {
    public abstract double calcular(double a, double b);
}

class Soma extends Operacao {
    public double calcular(double a, double b) {
        return a + b;
    }
}

class Subtracao extends Operacao {
    public double calcular(double a, double b) {
        return a - b;
    }
}

class Multiplicacao extends Operacao {
    public double calcular(double a, double b) {
        return a * b;
    }
}

class Divisao extends Operacao {
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida!");
        }
        return a / b;
    }
}

class RaizQuadrada extends Operacao {
    public double calcular(double a, double b) {
        if (a < 0) {
            throw new ArithmeticException("Raiz quadrada de número negativo não é permitida!");
        }
        return Math.sqrt(a);
    }
}

public class exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\nEscolha uma operação:");
                System.out.println("1. Soma");
                System.out.println("2. Subtração");
                System.out.println("3. Multiplicação");
                System.out.println("4. Divisão");
                System.out.println("5. Raiz Quadrada");
                System.out.println("6. Sair");

                int escolha = scanner.nextInt();
                if (escolha == 6) {
                    continuar = false;
                    System.out.println("Encerrando o programa...");
                    break;
                }

                System.out.print("Digite o primeiro número: ");
                double num1 = scanner.nextDouble();
                double num2 = 0;
                if (escolha != 5) {
                    System.out.print("Digite o segundo número: ");
                    num2 = scanner.nextDouble();
                }

                Operacao operacao;
                switch (escolha) {
                    case 1:
                        operacao = new Soma();
                        break;
                    case 2:
                        operacao = new Subtracao();
                        break;
                    case 3:
                        operacao = new Multiplicacao();
                        break;
                    case 4:
                        operacao = new Divisao();
                        break;
                    case 5:
                        operacao = new RaizQuadrada();
                        break;
                    default:
                        throw new InputMismatchException("Operação inválida!");
                }

                double resultado = operacao.calcular(num1, num2);
                System.out.println("Resultado: " + resultado);
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada inválida! " + e.getMessage());
                scanner.next(); // Limpa a entrada inválida
            } catch (ArithmeticException e) {
                System.out.println("Erro matemático: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

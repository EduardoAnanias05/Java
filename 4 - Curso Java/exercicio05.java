import java.util.Scanner;

// Exceção personalizada para tratar entradas inválidas
class ValorInvalidoException extends Exception {
    public ValorInvalidoException(String message) {
        super(message);
    }
}

public class exercicio05 {
    
    // Método recursivo para calcular o fatorial
    public static int fatorial(int n) throws ValorInvalidoException {
        if (n < 0) {
            throw new ValorInvalidoException("O valor inserido é negativo. Apenas números inteiros positivos são permitidos.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite um número inteiro positivo para calcular o fatorial: ");
                int numero = scanner.nextInt();

                // Chama o método recursivo para calcular o fatorial
                int resultado = fatorial(numero);
                System.out.println("O fatorial de " + numero + " é: " + resultado);
                entradaValida = true;  // Se tudo correu bem, define a entrada como válida

            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next();  // Limpa o buffer de entrada para evitar loop infinito
            }
        }

        scanner.close();
    }
}
